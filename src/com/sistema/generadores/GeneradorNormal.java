package com.sistema.generadores;

import org.apache.commons.math3.distribution.NormalDistribution;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorNormal implements GeneradorLaminas{
	
	static GeneradorNormal instance;
	
	public static GeneradorNormal getInstance(){
		if(instance == null){
			instance = new GeneradorNormal();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		NormalDistribution distribucion = new NormalDistribution();
		double value = distribucion.sample();
		System.out.println(value);
		return null;
	}

	@Override
	public void setN(Integer n) {
		// TODO Auto-generated method stub
		
	}

}
