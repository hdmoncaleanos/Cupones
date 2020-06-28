package com.sistema.objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.simulador.utils.Utils;
import com.sistema.constantes.Constantes;
import com.sistema.principal.Propiedades;

public class Simulacion {
	
	private int cantidad_rocas; // cantidad de rocas que se simularan.
	public int n;	// alto de la roca
	public int m; // ancho de la roca  
	private float deltaP; //variacion de p entre ejecuciones.
	public List<Resultado> resultados;
		
	public void inicializar(){
			String propiedad_n = Propiedades.obtenerPropiedad("n");
			if(propiedad_n == null || !StringUtils.isNumeric(propiedad_n)){
				throw new RuntimeException("No se encuentra configurada correctamente la propiedad: n");
			}
			this.n = Integer.parseInt(propiedad_n);
			
			String propiedad_m = Propiedades.obtenerPropiedad("m");
			if(propiedad_m == null || !StringUtils.isNumeric(propiedad_m)){
				throw new RuntimeException("No se encuentra configurada correctamente la propiedad: m");
			}
			this.m = Integer.parseInt(propiedad_m);
			
			
			String propiedad_delta_p = Propiedades.obtenerPropiedad("delta_p");
			if( propiedad_delta_p == null ){
				throw new RuntimeException("No se encuentra configurada la propiedad: delta_p");
			} else{
				Pattern p = Pattern.compile("^\\d*\\.?\\d*$");
				Matcher m = p.matcher(propiedad_delta_p);
				if( !m.matches() ){
					throw new RuntimeException("No se encontro un valor valido para la propiedad: n");
				}
				this.deltaP = Float.parseFloat(propiedad_delta_p);
			}
			
			String propiedad_cantidad = Propiedades.obtenerPropiedad("cantidad_rocas");
			if(propiedad_cantidad == null || !StringUtils.isNumeric(propiedad_cantidad)){
				throw new RuntimeException("No se encuentra configurada correctamente la propiedad: propiedad_cantidad");
			}
			this.cantidad_rocas = Integer.parseInt(propiedad_cantidad);
		
	}

	public void simular(){
		resultados = new ArrayList<Resultado>();
		
		resultados.add(new Resultado(0f, 0f));		
		
		for (float p = deltaP; p <= 1; p+=deltaP) { // Para p desde delta_p hasta 1
			System.out.println("\n########## Inicio ejecucion para p = " + p + " ##########\n");
			Ejecucion ejecucion = new Ejecucion(cantidad_rocas, p);
			float probabilidad_percolacion = ejecucion.calcularProbabilidadPercolacion(n, m);
			resultados.add(new Resultado(p, probabilidad_percolacion));
			
			System.out.println("Probabilidad de percolacion = " + probabilidad_percolacion);
			
			System.out.println("\n########## Fin de ejecucion para p = " + p + " ##########\n");
			
		}
		resultados.add(new Resultado(1.0f, 1.0f));
		Utils.imprimirResultados(resultados);
	}
}

