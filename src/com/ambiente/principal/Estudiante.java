package com.ambiente.principal;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	
	private String id_estudiante;
	private Album album;
	private ArrayList<Integer> laminas_repetidas;
	private Integer laminas_compradas;
	
	public Estudiante(String id_estudiante, Integer cantidad_laminas) {
		this.id_estudiante = id_estudiante;
		this.album = new Album(cantidad_laminas);
		this.laminas_repetidas = new ArrayList<Integer>();
		this.laminas_compradas = 0;
	}
	
	public String getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(String id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public ArrayList<Integer> getLaminas_repetidas() {
		return laminas_repetidas;
	}
	public void setLaminas_repetidas(ArrayList<Integer> laminas_repetidas) {
		this.laminas_repetidas = laminas_repetidas;
	}

	public void intercambiarLaminas(Estudiante estudiante2) {
		List<Integer> posible_cambio1 = new ArrayList<Integer>(); 
		List<Integer> posible_cambio2 = new ArrayList<Integer>(); 
		
		for (Integer id_lamina : this.getLaminas_repetidas()) {
			if(!estudiante2.getAlbum().tieneLamina(id_lamina)){
				posible_cambio1.add(id_lamina);
			}
		}
		
		for (Integer id_lamina : estudiante2.getLaminas_repetidas()) {
			if(!this.getAlbum().tieneLamina(id_lamina)){
				posible_cambio2.add(id_lamina);
			}
		}
		
		if(!posible_cambio1.isEmpty() && !posible_cambio2.isEmpty() ){
			int cambios = Math.max(posible_cambio1.size(), posible_cambio2.size());
			for(int i = 1; i<=cambios; i++){
				Integer lamina1 = posible_cambio1.get(i);
				Integer lamina2 = posible_cambio2.get(i);
				this.getLaminas_repetidas().remove(lamina1);
				estudiante2.getLaminas_repetidas().remove(lamina2);
				this.getAlbum().agregarLamina(lamina2);
				estudiante2.getAlbum().agregarLamina(lamina1);
			}
			
		}

	}

	public void agregarLaminaComprada(Integer id_lamina) {
		if( this.getAlbum().tieneLamina(id_lamina) ){
			this.getLaminas_repetidas().add(id_lamina);
		} else {
			this.getAlbum().agregarLamina(id_lamina);
		}
		laminas_compradas++;
	}
	
	public boolean tieneAlbumLleno(){
		return album.estaLleno();
	}

	public Integer getLaminas_compradas() {
		return laminas_compradas;
	}

	public void setLaminas_compradas(Integer laminas_compradas) {
		this.laminas_compradas = laminas_compradas;
	}
	
}
