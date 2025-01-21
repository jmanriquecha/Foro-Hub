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

    // Crea nuevos topicos
    @PostMapping
    public ResponseEntity registrarTopicos(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var detalleTopico = registroDeTopicos.agregarTopico(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }
}
