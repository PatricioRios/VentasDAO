/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Hugo Chanampe
 */
public class Cliente {
    
    private Integer id;
    
    private String documento;
    
    private String nombre;
    
    private String apellido;
    
    private TipoCliente tipoCliente;
    
    private Date fechaNacimiento;

    private String cuil;

    public Cliente() {
    }

    public Cliente(Integer id, String documento, String nombre, String apellido, TipoCliente tipoCliente, Date fechaNacimiento, String cuil) {

        validarCampos(
                Optional.ofNullable(id),
                Optional.ofNullable(documento),
                Optional.ofNullable(nombre),
                Optional.ofNullable(apellido),
                Optional.ofNullable(tipoCliente),
                Optional.ofNullable(fechaNacimiento),
                Optional.ofNullable(cuil)
        );

        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.cuil = cuil;
    }

    private void validarCampos(
            Optional<Integer> id,
            Optional<String> documento,
            Optional<String> nombre,
            Optional<String> apellido,
            Optional<TipoCliente> tipoCliente,
            Optional<Date> fechaNacimiento,
            Optional<String> cuil
    ){
        if(documento.isPresent()){
            validarDocumento(documento.get());
        }
        if(id.isPresent() && id.get() < 0){
            throw new IllegalArgumentException("El id no puede ser negativo");
        }
        if(nombre.isPresent() && nombre.get().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(apellido.isPresent() && apellido.get().isEmpty()){
            throw new IllegalArgumentException("El apellido no puede estar vacio");
        }
        if(fechaNacimiento.isPresent() && fechaNacimiento.get().after(new Date())){
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }
        //la forma del cuil es XY - [Número de DNI] - Z
        if(cuil.isPresent() && cuil.get().isEmpty() || cuil.get().split("-").length != 3 || !cuil.get().matches("\\d{2}-\\d+-\\d")){
            throw new IllegalArgumentException("El cuil no puede estar vacio");
        }
    }

    private void validarDocumento(String documento) {
        //verificar que el documento no tenga letras ni caracteres especiales
        if(!documento.matches("\\d+")){
            throw new IllegalArgumentException("El documento solo debe contener numeros");
        }
        //validar que sea mayor o igual a 0.
        if(Integer.parseInt(documento) < 0){
            throw new IllegalArgumentException("El documento no puede ser negativo");
        }
    }


    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDocumento() { return documento;
    }

    public void setDocumento(String documento) {

        validarDocumento(documento);


        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoCliente=" + tipoCliente + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

 
    
}
