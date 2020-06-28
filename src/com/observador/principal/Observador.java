package com.observador.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ambiente.principal.Ambiente;
import com.ambiente.principal.Estudiante;

public class Observador {
	
	private static Observador observador;
	private List<Observacion> observacionesPorAmbiente; 
	
	private Observador() {
		this.observacionesPorAmbiente = new ArrayList<>();
	}
	
	public static Observador getInstance() {
		
		if( observador == null ) {
			observador = new Observador();
		}
		
		return observador;
	}

	public List<Observacion> getAlbumesLlenosPorAmbiente() {
		return observacionesPorAmbiente;
	}

	public void setAlbumesLlenosPorAmbiente(List<Observacion> albumesLlenosPorAmbiente) {
		this.observacionesPorAmbiente = albumesLlenosPorAmbiente;
	}

	public void getInfoAmbiente(Ambiente ambiente) {
		
		Map<String, Estudiante> estudiantesAmbiente = ambiente.getEstudiantes();
		Observacion observacion = new Observacion();
		
		for (Estudiante estudiante : estudiantesAmbiente.values()) {

			observacion.cantidadEstudiantes = ambiente.getCantidad_estudiantes();
			

			if(estudiante.tieneAlbumLleno()) {
				observacion.albumesLlenosAmbiente++;
				observacion.laminasCompradasAlbumesLlenos += estudiante.getLaminas_compradas();
			}
			
			observacion.totalLaminasCompradasAmbiente += estudiante.getLaminas_compradas();
			
		}
		
		observacion.cantidadAmistades = ambiente.getAmistades().getEdgeCount();
		
		observacionesPorAmbiente.add(observacion);
		
	}
	
	public void generarAnalisis() {
		for (Observacion observacion : observacionesPorAmbiente) {
			
			System.out.println(observacion);
			
		}
	}

}
