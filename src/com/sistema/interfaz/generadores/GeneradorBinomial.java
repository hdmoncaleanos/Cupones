package com.sistema.interfaz.generadores;

public class GeneradorBinomial implements GeneradorLaminas{
	
	GeneradorBinomial instance;
	
	public GeneradorBinomial getInstance(){
		if(instance == null){
			instance = new GeneradorBinomial();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		// TODO Auto-generated method stub
		return null;
	}

}
