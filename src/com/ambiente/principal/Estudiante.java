package com.ambiente.principal;

import java.util.ArrayList;

public class Estudiante {
	
	private String id_estudiante;
	private Album album;
	private ArrayList<Integer> laminas_repetidas;
	
	public Estudiante(String id_estudiante, Integer cantidad_laminas) {
		this.id_estudiante = id_estudiante;
		this.album = new Album(cantidad_laminas);
		this.laminas_repetidas = new ArrayList<Integer>();
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
}
