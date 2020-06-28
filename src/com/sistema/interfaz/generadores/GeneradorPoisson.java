package com.sistema.interfaz.generadores;

public class GeneradorPoisson implements GeneradorLaminas{
	
	GeneradorPoisson instance;
	
	public GeneradorPoisson getInstance(){
		if(instance == null){
			instance = new GeneradorPoisson();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		// TODO Auto-generated method stub
		return null;
	}

}
