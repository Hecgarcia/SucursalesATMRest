package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalAtm implements Serializable {
	
		
	private String servicios;
	private String valor100;
	private String tercervalor;
	private String[] cadena;
	
	
	
	private static final long serialVersionUID = -4014161050166504823L;
	

}
