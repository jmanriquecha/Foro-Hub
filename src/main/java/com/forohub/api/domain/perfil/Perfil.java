package com.forohub.api.domain.perfil;

import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToMany(mappedBy = "perfiles")
    private Set<Usuario> usuarios = new HashSet<>();
}
