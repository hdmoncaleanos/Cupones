package com.sistema.generadores;

import org.apache.commons.math3.distribution.GeometricDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorGeometrica implements GeneradorLaminas{
	
	Integer n;	
	
	@Override
	public Integer obtenerLamina() {
		GeometricDistribution distribucion = new GeometricDistribution(1.0/n);
		return distribucion.sample();
	}

	@Override
	public void setN(Integer n) {
		this.n = n;
	}

}
