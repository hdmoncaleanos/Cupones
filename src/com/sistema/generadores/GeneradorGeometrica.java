package com.sistema.generadores;

import org.apache.commons.math3.distribution.GeometricDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorGeometrica implements GeneradorLaminas{
	
	GeneradorGeometrica instance;
	
	public GeneradorGeometrica getInstance(){
		if(instance == null){
			instance = new GeneradorGeometrica();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		GeometricDistribution distribucion = new GeometricDistribution(0.5);
		return null;
	}

}
