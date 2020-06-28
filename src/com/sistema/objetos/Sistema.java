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
	private Observador observador;
	private Map<String, GeneradorLaminas> generadores;
	
	public void inicializar(){
		
		generadores = new HashMap<String, GeneradorLaminas>();
		generadores.put(Constantes.TIPO_PROBABILIDAD_BINOMIAL, new GeneradorBinomial());
		generadores.put(Constantes.TIPO_PROBABILIDAD_GEOMETRICA, new GeneradorGeometrica());
		generadores.put(Constantes.TIPO_PROBABILIDAD_POISSON, new GeneradorPoisson());
		generadores.put(Constantes.TIPO_PROBABILIDAD_TABLA, new GeneradorTabla());
		generadores.put(Constantes.TIPO_PROBABILIDAD_UNIFORME, new GeneradorUniforme());

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

		switch (distribucion){
			case (Constantes.TIPO_PROBABILIDAD_NORMAL):
				GeneradorNormal gen = GeneradorNormal.getInstance();
				gen.setN(this.n);
				generadores.put(Constantes.TIPO_PROBABILIDAD_NORMAL, gen);
				break;
		}

	}
	
	public void simular(){
		observador = new Observador();
		
		for (int i = 1; i<= cantidad_ambientes; i++){
			System.out.println("\n########## Inicio ejecucion para ambiente " + i + " ##########\n");
			Ambiente ambiente = new Ambiente(10, generadores.get(distribucion), n);
			Integer cantidad_pasos = 100;
			ambiente.ejecutar(cantidad_pasos );
			System.out.println("\n########## Fin de ejecucion para ambiente " + i + " ##########\n");
			
		}
	}
}
