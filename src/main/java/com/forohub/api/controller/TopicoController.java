package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos registroDeTopicos;

    @Autowired
    private TopicoRepository repository;

    // Lista los topicos
    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        var detalleTopico = registroDeTopicos.listarTopicos(paginacion);
        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalleTopico(@PathVariable Long id){
        return registroDeTopicos.muestraDetalleTopico(id);
    }

    // Crea nuevos topicos
    @PostMapping
    public ResponseEntity<?> registrarTopicos(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        return registroDeTopicos.agregarTopico(datosRegistroTopico);
    }
}
