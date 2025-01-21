package com.forohub.api.domain.topico;

import com.forohub.api.domain.ValidacionExcepcion;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.springframework.http.ResponseEntity.status;

@Service
public class RegistroDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Agrega nuevo topico
    public ResponseEntity<?> agregarTopico(@Valid DatosRegistroTopico datosRegistroTopico) {

        if (!usuarioRepository.existsById(datosRegistroTopico.idUsuario())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe el usuario con ese ID");
        }

        if (!cursoRepository.existsById(datosRegistroTopico.idCurso())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe el curso con ese ID");
        }

        if (datosRegistroTopico.mensaje() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El mensaje no puede estar vacío");
        }

        if (datosRegistroTopico.titulo() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No puede estar vacío el título");
        }

        // Comprobar que titulo y mensaje no esten duplicados
        if(topicoRepository.existsByTitulo(datosRegistroTopico.titulo()) &&
                topicoRepository.existsByMensaje(datosRegistroTopico.mensaje())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un topico con título y mensaje identicos!");
        }

        // Elije usuario / autor
        var autor = usuarioRepository.findById(datosRegistroTopico.idUsuario()).get();
        var curso = cursoRepository.findById(datosRegistroTopico.idCurso()).get();
        var titulo = datosRegistroTopico.titulo();
        var mensaje = datosRegistroTopico.mensaje();
        var fechaRegistro = LocalDateTime.now();
        var status = Status.ACTIVO;

        var topico = new Topico(titulo, mensaje, autor, curso, fechaRegistro, status);
        topicoRepository.save(topico);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DatosDetalleTopico(topico));
    }

    // Listar todos los topicos
    public Page<DatosDetalleTopico> listarTopicos(Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosDetalleTopico::new);
    }

    // Muestra cada topico
    public ResponseEntity<?> muestraDetalleTopico(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("El ID es obligatorio para buscar el Topico");
        }

        if(!topicoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    // No existe el topico en la base de datos
                    .body("El tópico con el ID especificado no existe.");
        }

        return ResponseEntity.ok(new DatosDetalleTopico(topicoRepository.getReferenceById(id)));
    }
}
