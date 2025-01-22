package com.forohub.api.controller;

import com.forohub.api.domain.usuario.DatosAutenticacionUsuario;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.infra.DatosJWTToken;
import com.forohub.api.infra.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
            Authentication AuthToken = new UsernamePasswordAuthenticationToken(
                    datosAutenticacionUsuario.username(),
                    datosAutenticacionUsuario.contrasena()
            );
            var usuarioAutenticado = authenticationManager.authenticate(AuthToken);
            var JWTToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal()); // Usuario que ya fue autenticado en el sistema
            return ResponseEntity.ok(new DatosJWTToken(JWTToken));
    }

}
