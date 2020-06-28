package com.sistema.generadores;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorUniforme implements GeneradorLaminas{
	
	GeneradorUniforme instance;
	
	public GeneradorUniforme getInstance(){
		if(instance == null){
			instance = new GeneradorUniforme();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		// TODO Auto-generated method stub
		return null;
	}

}
