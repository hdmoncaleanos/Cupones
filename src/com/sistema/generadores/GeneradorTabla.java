package com.sistema.generadores;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class GeneradorTabla implements GeneradorLaminas{
	
	GeneradorTabla instance;
	
	public GeneradorTabla getInstance(){
		if(instance == null){
			instance = new GeneradorTabla();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setN(Integer n) {
		// TODO Auto-generated method stub
		
	}

}
