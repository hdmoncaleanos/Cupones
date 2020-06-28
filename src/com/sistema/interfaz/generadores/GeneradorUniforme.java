package com.sistema.interfaz.generadores;

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
