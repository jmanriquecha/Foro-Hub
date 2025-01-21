package com.forohub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        Long idUsuairio, // Autor
        Long idCurso,
        LocalDateTime fechaCreacion,
        Status status
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getUsuario().getId(), topico.getCurso().getId(),
                topico.getFechaCreacion(), topico.getStatus());
    }
}
