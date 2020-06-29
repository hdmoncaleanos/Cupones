package com.sistema.objetos;

import java.util.HashMap;
import java.util.Map;

import com.sistema.generadores.*;
import org.apache.commons.lang3.StringUtils;

import com.ambiente.principal.Ambiente;
import com.observador.principal.Observador;
import com.sistema.constantes.Constantes;
import com.sistema.interfaz.generadores.GeneradorLaminas;
import com.sistema.principal.Propiedades;

public class Sistema {
	
	private Integer n;
	private String distribucion;
	private int cantidad_ambientes;
	private int cantidad_pasos;
	private Observador observador;
	private Map<String, GeneradorLaminas> generadores;
	private Integer cantidad_estudiantes;

	public void inicializar(){
		
		generadores = new HashMap<String, GeneradorLaminas>();
		generadores.put(Constantes.TIPO_PROBABILIDAD_BINOMIAL, new GeneradorBinomial());
		generadores.put(Constantes.TIPO_PROBABILIDAD_GEOMETRICA, new GeneradorGeometrica());
		generadores.put(Constantes.TIPO_PROBABILIDAD_POISSON, new GeneradorPoisson());
		generadores.put(Constantes.TIPO_PROBABILIDAD_TABLA, GeneradorTabla.getInstance());
		generadores.put(Constantes.TIPO_PROBABILIDAD_UNIFORME, new GeneradorUniforme());
		generadores.put(Constantes.TIPO_PROBABILIDAD_NORMAL, GeneradorNormal.getInstance());

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

		String propiedad_cantidad_pasos = Propiedades.obtenerPropiedad("cantidad_pasos");
		if(propiedad_cantidad == null || !StringUtils.isNumeric(propiedad_cantidad)){
			throw new RuntimeException("No se encuentra configurada correctamente la propiedad: cantidad_pasos");
		}
		this.cantidad_pasos = Integer.parseInt(propiedad_cantidad_pasos);

		String propiedad_cantidad_estudiantes = Propiedades.obtenerPropiedad("cantidad_estudiantes");
		if(propiedad_cantidad == null || !StringUtils.isNumeric(propiedad_cantidad)){
			throw new RuntimeException("No se encuentra configurada correctamente la propiedad: cantidad_estudiantes");
		}
		this.cantidad_estudiantes = Integer.parseInt(propiedad_cantidad_estudiantes);

	}
	
	public void simular(){
		observador = Observador.getInstance();
		
		for (int i = 1; i<= cantidad_ambientes; i++){
			System.out.println("\n########## Inicio ejecucion para ambiente " + i + " ##########\n");
			GeneradorLaminas generador = generadores.get(distribucion);
			generador.setN(n);
			Ambiente ambiente = new Ambiente(cantidad_estudiantes, generador, n);
			ambiente.ejecutar( cantidad_pasos );
			observador.getInfoAmbiente(ambiente);
			System.out.println("\n########## Fin de ejecucion para ambiente " + i + " ##########\n");
			
		}
		
		observador.generarAnalisis();
		
	}
}
