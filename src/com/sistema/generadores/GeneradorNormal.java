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
		double prob = (distribucion.sample() + distribucion.getSupportUpperBound()) / (distribucion.getSupportUpperBound() - distribucion.getSupportLowerBound());

		if(n != null){
			Integer laminilla = (int) Math.floor(prob * this.n);
			System.out.println(laminilla);
			return laminilla;
		}
		return null;
	}

	@Override
	public void setN(Integer n) {
		this.n = n;
	}

}
