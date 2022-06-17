package com.mx.animalia.application.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
public class CiudadanoDatosModel {
    String id;
    @NotNull
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    String nombreCiudadano;
    String tipoEspecieCiudadano;
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    String descCiudadano;
    @NotNull
    @DecimalMax("150.0")
    Double pesoEspecie;
    @NotNull
    @DecimalMax("2.00")
    @DecimalMin("1.50")
    Double alturapecie;
    @NotNull
    @NotEmpty
    @Pattern(regexp="[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",message = "Invalid Input")
    String urlFotoCiudadano;
    String tieneMascota;
    ArrayList<CiudadanosRolesModel> rolesCiudadano;
}
