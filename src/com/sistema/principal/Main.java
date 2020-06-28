package com.sistema.principal;

import java.io.IOException;

import com.sistema.objetos.Simulacion;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Propiedades.cargarPropiedades();

		Simulacion s = new Simulacion();
		
		s.inicializar();

		long inicio = System.currentTimeMillis();
		System.out.println("Iniciando simulacion");
		s.simular();
         
        long fin = System.currentTimeMillis();
         
        double tiempo = (double) ((fin - inicio)/1000);
         
        System.out.println("Tiempo simulacion: " + tiempo +" segundos");
		
	}
	
}
