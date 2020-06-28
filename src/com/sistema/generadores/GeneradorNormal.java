package com.sistema.generadores;

import org.apache.commons.math3.distribution.NormalDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorNormal implements GeneradorLaminas{
	
	static GeneradorNormal instance;
	static private Integer n;
	
	public static GeneradorNormal getInstance(){
		if(instance == null){
			instance = new GeneradorNormal();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		NormalDistribution distribucion = new NormalDistribution();
		double prob = (distribucion.sample() + (distribucion.getStandardDeviation() * 3)) / (distribucion.getStandardDeviation() * 6);

		if(this.n != null){
			Integer laminilla = (int) Math.floor(prob * this.n);
			System.out.println(laminilla);
			++laminilla;
			return laminilla;
		}
		return null;
	}

	@Override
	public void setN(Integer n) {
		this.n = n;
	}

}
