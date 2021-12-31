package com.ibm.academia.apirest.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.academia.apirest.models.entities.SucursalAtm;



@RestController
@RequestMapping("/cajeros")
public class SucursalAtmController {

	private final RestTemplate restTemplate;
	
	@Autowired
	public SucursalAtmController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	/**
	 * EndPoint para validar que si se esta consumiendo el Json
	 * @return datos de cajeros y sucursales del json de banamex
	 * @author Hector Garcia Espinobarrro 29-12-2021
	 */
	@GetMapping("/lista")
	public List<SucursalAtm> obtenerCaleros() {
		String url = "https://www.banamex.com/localizador/jsonP/json5.json";
		SucursalAtm[] lista = restTemplate.getForObject(url, SucursalAtm[].class);
		
		return Arrays.asList(lista);
	     
		
	}
	
	/**
	 * EndPoint para validar que si se esta consumiendo el Json
	 * @return datos de cajeros y sucursales del json de banamex
	 * @author Hector Garcia Espinobarrro 29-12-2021
	 */	
	@GetMapping("/sucursales")
    public String obtenerLista(){
		
		ResponseEntity<Object[]> responseEntiti = restTemplate.getForEntity("https://www.banamex.com/localizador/jsonP/json5.json", Object[].class);
		
		String objetos = responseEntiti.getBody().toString();
		System.out.println(objetos);
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(objetos).getAsJsonObject();
		Set<Entry<String,JsonElement>> set = obj.entrySet();
		
		for (Entry<String,JsonElement> j : set) {
            obj = (JsonObject) j.getValue();
		    obj.get("100");
		    obj.get("800");
		    obj.get("500");
		    obj.get("110");
		    obj.get("300");
		    obj.get("400");
		    obj.get("600");
		    obj.get("900");
		    obj.get("950");
		}
		
	    return objetos;
	}
	
}
