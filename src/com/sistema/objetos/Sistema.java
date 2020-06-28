package com.sistema.objetos;

import org.apache.commons.lang3.StringUtils;

import com.ambiente.principal.Ambiente;
import com.observador.principal.Observador;
import com.sistema.principal.Propiedades;

public class Sistema {
	
	private Integer n;
	private String distribucion;
	private int cantidad_ambientes;
	private Observador observador;
	
	public void inicializar(){
		String propiedad_n = Propiedades.obtenerPropiedad("n");
		if(propiedad_n == null || !StringUtils.isNumeric(propiedad_n)){
			throw new RuntimeException("No se encuentra configurada correctamente la propiedad: n");
		}
		this.n = Integer.parseInt(propiedad_n);
		
		String propiedad_distribucion = Propiedades.obtenerPropiedad("distribucion");
		if(propiedad_distribucion == null ){
			throw new RuntimeException("No se encuentra configurada correctamente la propiedad: distribucion");
		}
		this.distribucion = propiedad_distribucion;
		
		String propiedad_cantidad = Propiedades.obtenerPropiedad("cantidad_ambientes");
		if(propiedad_cantidad == null || !StringUtils.isNumeric(propiedad_cantidad)){
			throw new RuntimeException("No se encuentra configurada correctamente la propiedad: propiedad_cantidad");
		}
		this.cantidad_ambientes = Integer.parseInt(propiedad_cantidad);
	
	}
	
	public void simular(){
		observador = new Observador();
		
		for (int i = 1; i< cantidad_ambientes; i++){
			System.out.println("\n########## Inicio ejecucion para ambiente " + i + " ##########\n");
			Ambiente ambiente = new Ambiente();
		
			
			System.out.println("\n########## Fin de ejecucion para ambiente " + i + " ##########\n");
			
		}
	}
}
