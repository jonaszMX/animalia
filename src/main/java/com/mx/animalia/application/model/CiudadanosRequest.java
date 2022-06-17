package com.mx.animalia.application.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
public class CiudadanosRequest {
	@NotNull
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	String nombreCiudadano;
	@NotNull
	@NotEmpty
	String tipoEspecieCiudadano;
	@NotNull
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	String descCiudadano;
	@NotNull
	@NotEmpty
	@DecimalMax("150.00")
	@DecimalMin("50.00")
	Double pesoEspecie;
	@NotNull
	@NotEmpty
	@DecimalMax("2.00")
	@DecimalMin("1.50")
	Double alturapecie;
	@NotNull
	@NotEmpty
	@Pattern(regexp="[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",message = "Invalid Input")
	String urlFotoCiudadano;
	@NotNull
	@NotEmpty
	@AssertFalse
	@AssertTrue
	boolean tieneMascota;
	ArrayList<CiudadanosRolesModel> rolesCiudadano;
}
