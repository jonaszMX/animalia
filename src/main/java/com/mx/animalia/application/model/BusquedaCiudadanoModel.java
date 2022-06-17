package com.mx.animalia.application.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class BusquedaCiudadanoModel {
    @NotNull
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    String nombre;
    @NotNull
    @NotEmpty
    @Min(value = 1, message = "El valor deber ser mayor de 0")
    int idEspecie;
    @NotNull
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    String descCiudadano;
    @NotNull
    @NotEmpty
    @Min(value = 1, message = "El valor deber ser mayor de 0")
    int idRol;
    String tieneMascota;
}
