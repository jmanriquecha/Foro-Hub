package com.forohub.api.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.respuesta.Respuesta;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso, LocalDateTime fecha, Status status) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.usuario = autor;
        this.curso = curso;
        this.fechaCreacion = fecha;
        this.status = status;
    }
}
