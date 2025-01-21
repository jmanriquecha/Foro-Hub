package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso idCurso;
    private String respuestas;

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.usuario = autor;
        this.idCurso = curso;
    }
}
