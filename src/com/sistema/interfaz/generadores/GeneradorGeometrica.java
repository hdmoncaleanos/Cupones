package com.sistema.interfaz.generadores;

public class GeneradorGeometrica implements GeneradorLaminas{
	
	GeneradorGeometrica instance;
	
	public GeneradorGeometrica getInstance(){
		if(instance == null){
			instance = new GeneradorGeometrica();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		// TODO Auto-generated method stub
		return null;
	}

}
