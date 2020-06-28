package com.sistema.objetos;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ambiente.principal.Ambiente;
import com.observador.principal.Observador;
import com.sistema.constantes.Constantes;
import com.sistema.generadores.GeneradorBinomial;
import com.sistema.generadores.GeneradorGeometrica;
import com.sistema.generadores.GeneradorPoisson;
import com.sistema.generadores.GeneradorTabla;
import com.sistema.generadores.GeneradorUniforme;
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
		generadores.put(Constantes.TIPO_PROBABILIDAD_BINOMIAL, new GeneradorGeometrica());
		generadores.put(Constantes.TIPO_PROBABILIDAD_BINOMIAL, new GeneradorPoisson());
		generadores.put(Constantes.TIPO_PROBABILIDAD_BINOMIAL, new GeneradorTabla());
		generadores.put(Constantes.TIPO_PROBABILIDAD_BINOMIAL, new GeneradorUniforme());

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
		
		for (int i = 1; i<= cantidad_ambientes; i++){
			System.out.println("\n########## Inicio ejecucion para ambiente " + i + " ##########\n");
			Ambiente ambiente = new Ambiente(10, generadores.get(distribucion), n);
			
			System.out.println("\n########## Fin de ejecucion para ambiente " + i + " ##########\n");
			
		}
	}
}
