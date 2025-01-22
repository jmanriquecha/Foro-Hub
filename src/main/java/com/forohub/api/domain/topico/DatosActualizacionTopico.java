package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        Long id,
        @NotNull
        String titulo,
        @NotNull
        String mensaje
) {
}
