package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        Long idUsuario, // Autor
        Long idCurso,
        LocalDateTime fechaCreacion,
        Status status
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getUsuario().getId(), topico.getIdCurso().getId(),
                topico.getFechaCreacion(), topico.getStatus());
    }
}
