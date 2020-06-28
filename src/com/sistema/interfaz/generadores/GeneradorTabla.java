package com.sistema.interfaz.generadores;

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

}
