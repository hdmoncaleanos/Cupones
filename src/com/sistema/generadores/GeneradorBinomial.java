package com.sistema.generadores;

import org.apache.commons.math3.distribution.BinomialDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorBinomial implements GeneradorLaminas{
	
	GeneradorBinomial instance;
	
	public GeneradorBinomial getInstance(){
		if(instance == null){
			instance = new GeneradorBinomial();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		BinomialDistribution distribucion = new BinomialDistribution(100, 0.1);
		return null;
	}

}
