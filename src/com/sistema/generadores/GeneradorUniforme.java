package com.sistema.generadores;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorUniforme implements GeneradorLaminas{
	private Integer n;
	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	GeneradorUniforme instance;
	
	public GeneradorUniforme getInstance(){
		if(instance == null){
			instance = new GeneradorUniforme();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		double randomDouble = Math.random();
		return (int) Math.floor(randomDouble * n) ;
	}

}
