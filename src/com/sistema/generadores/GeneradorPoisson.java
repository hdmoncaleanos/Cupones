package com.sistema.generadores;

import org.apache.commons.math3.distribution.PoissonDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorPoisson implements GeneradorLaminas{
	
	private Integer n;
	
	@Override
	public Integer obtenerLamina() {
		PoissonDistribution distribucion = new PoissonDistribution(1);
		return distribucion.sample();
	}

	@Override
	public void setN(Integer n) {
		this.n = n;
	}

}
