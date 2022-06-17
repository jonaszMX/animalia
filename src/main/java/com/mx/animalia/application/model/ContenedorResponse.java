package com.mx.animalia.application.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContenedorResponse<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;//
	private String descripcion;
	private boolean isError;//true o false
	private T data;
	
	public String toString() {
		return "[codigo:" + codigo +
				", descripcion:" + descripcion + 
				", ups:" + isError +
				", data:" + data +
				"]";
	}
}
