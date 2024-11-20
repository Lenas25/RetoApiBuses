package civa.reto.apiBuses.dto;

import java.util.Date;

public record BusData(
        Long id,
        int numeroBus,
        String placa,
        String caracteristicas,
        Date created_at,
        boolean is_active,
        MarcaData marcaData
) {
}
