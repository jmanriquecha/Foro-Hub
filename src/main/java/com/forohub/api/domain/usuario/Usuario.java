package com.forohub.api.domain.usuario;

import com.forohub.api.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<Perfil> perfiles = new HashSet<>();
}
