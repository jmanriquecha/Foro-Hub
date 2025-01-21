package com.forohub.api.domain.topico;

import com.forohub.api.domain.ValidacionExcepcion;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosDetalleTopico agregarTopico(@Valid DatosRegistroTopico datosRegistroTopico) {

        if(!usuarioRepository.existsById(datosRegistroTopico.idUsuario())){
            throw new ValidacionExcepcion("No existe un usuario con ese id");
        }

        if(!cursoRepository.existsById(datosRegistroTopico.idCurso())){
            throw new ValidacionExcepcion("No existe el curso");
        }

        if(datosRegistroTopico.mensaje() == null){
            throw new ValidacionExcepcion("El mensaje no puede estar vacio");
        }

        if (datosRegistroTopico.titulo() == null){
            throw new ValidacionExcepcion("No puede estar vacio el título");
        }

        // Elije usuario / autor
        var autor = usuarioRepository.findById(datosRegistroTopico.idUsuario()).get();
        var curso = cursoRepository.findById(datosRegistroTopico.idCurso()).get();
        var titulo = datosRegistroTopico.titulo();
        var mensaje = datosRegistroTopico.mensaje();
        var topico = new Topico(titulo, mensaje, autor, curso);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }
}
