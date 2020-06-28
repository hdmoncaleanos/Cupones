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
	
	@Override
	public Integer obtenerLamina() {
		double randomDouble = Math.random();
		Integer lamina = (int)  Math.floor(randomDouble * n );
		return  lamina + 1 ;
	}

}
