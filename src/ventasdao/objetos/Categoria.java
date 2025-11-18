/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

import java.util.Optional;

/**
 *
 * @author Hugo Chanampe
 */
public class Categoria {
   private Integer id;
   private String denominacion;
   private String descripcion;

    public Categoria() {
    }

    public Categoria(Integer id, String denominacion, String descripcion) {

        validarCampos(
                Optional.ofNullable(id),
                Optional.ofNullable(denominacion),
                Optional.ofNullable(descripcion)
        );

        this.id = id;
        this.denominacion = denominacion;
        this.descripcion = descripcion;
    }

    private void validarCampos(
            Optional<Integer> id,
            Optional<String> denominacion,
            Optional<String> descripcion
    ) {
        id.ifPresent(i -> {
            if (i < 0) {
                throw new IllegalArgumentException("ID no puede ser negativo");
            }
        });
        denominacion.ifPresent(d -> {
            if (d.isEmpty()) {
                throw new IllegalArgumentException("La denominacion no puede estar vacia");
            }
        });
        descripcion.ifPresent(d -> {
            if (d.isEmpty()) {
                throw new IllegalArgumentException("La descripcion no puede estar vacia");
            }
        });
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return denominacion;
    }
   
   
   
    
}
