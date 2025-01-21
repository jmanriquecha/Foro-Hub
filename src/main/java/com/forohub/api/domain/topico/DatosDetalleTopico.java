package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        Long idUsuario, // Autor
        Long idCurso
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getUsuario().getId(), topico.getIdCurso().getId());
    }
}
