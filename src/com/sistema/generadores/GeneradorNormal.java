package com.sistema.generadores;

import org.apache.commons.math3.distribution.NormalDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorNormal implements GeneradorLaminas {

	static GeneradorNormal instance;
	static private Integer n;

	public static GeneradorNormal getInstance() {
		if (instance == null) {
			instance = new GeneradorNormal();
		}
		return instance;
	}

	@Override
	public Integer obtenerLamina() {
		NormalDistribution distribucion = new NormalDistribution(0.5f,0.12f);

		
		double sample;
		do {
			sample = distribucion.sample();
			
			sample = (sample  * 0.9973)
					/ ( (0.5f+(3*0.12f)) - (0.5f-(3*0.12f)));
		}while( sample < 0 || sample > 1);
		
		if (this.n != null) {
			
			Integer lamina = (int)  Math.floor(sample * n );
			if (lamina < n) {
				lamina += 1; 
			}
			return lamina ;
		}
		return null;
	}

	@Override
	public void setN(Integer n) {
		this.n = n;
	}

}
