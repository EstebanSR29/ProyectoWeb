package com.ProyectoWeb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends Accesorio {
    private int cantidad;

    public Item() {
    }

    public Item(Accesorio accesorio) {
        super.setIdAccesorio(accesorio.getIdAccesorio());
        super.setNombre(accesorio.getNombre());
        super.setImagen(accesorio.getImagen());
        super.setPrecio(accesorio.getPrecio());
        super.setActivo(accesorio.isActivo());
        this.cantidad = 0;
    }
}