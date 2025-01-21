package com.forohub.api.domain.curso;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
