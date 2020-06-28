package com.ambiente.principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import com.simulador.utils.Utils;
import com.sistema.interfaz.generadores.GeneradorLaminas;
import com.sistema.principal.Propiedades;

public class Ambiente {
	
	private Integer cantidad_estudiantes;
	private Map<String, Estudiante> estudiantes;
	private GeneradorLaminas generador;
	private Graph amistades;
	private Integer pasos = 0;
	
	public Ambiente(Integer cantidad_estudiantes, GeneradorLaminas generador, Integer cantidad_laminas){
		this.generador = generador;
		this.cantidad_estudiantes = cantidad_estudiantes;
		
		estudiantes = new HashMap<String, Estudiante>();
		
		for(int i = 0; i < cantidad_estudiantes; i++){
			estudiantes.put(i + "", new Estudiante(i + "", cantidad_laminas));
		}
		Utils.println(estudiantes);
		amistades = new SingleGraph("Amistades");
	    Generator gen = new RandomGenerator(2);
	    gen.addSink(amistades);
	    gen.begin();
	    for(int i=0; i<cantidad_estudiantes - 3; i++)
	        gen.nextEvents();
	    gen.end();
	    
	    Iterable<? extends Edge> edges = amistades.getEachEdge();
	    for (Edge edge : edges) {
			System.out.println("Amistad : " + edge.getNode0().getId() + " a " + edge.getNode1().getId());
		}
	    int nodes = amistades.getNodeCount();
		int edgesn = amistades.getEdgeCount();
		System.out.println("n: " + nodes + ", M: " + edgesn + " n/M: " + (float) edgesn / (float) nodes );
//		amistades.display();
	}
	
	private void siguientePaso(){
		comprarLaminas();
		cambiarLaminas();
		pasos++;
	}

	private void cambiarLaminas() {
		Iterable<? extends Edge> edges = amistades.getEachEdge();
	    for (Edge edge : edges) {
	    	String id_estudiante1 = edge.getNode0().getId();
	    	String id_estudiante2 = edge.getNode1().getId();
	    	Estudiante estudiante1 = estudiantes.get(id_estudiante1);
	    	Estudiante estudiante2 = estudiantes.get(id_estudiante2);
	    	estudiante1.intercambiarLaminas(estudiante2);
		}
	}

	private void comprarLaminas() {
		Set<String> ids_estudiantes = estudiantes.keySet();
		for (String id_estudiante : ids_estudiantes) {
			Estudiante estudiante = estudiantes.get(id_estudiante);
			if(!estudiante.tieneAlbumLleno()){
				Integer id_lamina = generador.obtenerLamina();
				estudiante.agregarLaminaComprada(id_lamina);
			}
		}
	}
	
	public void ejecutar(Integer cantidad_pasos){
		for(int i = 0; i<cantidad_pasos; i++){
			siguientePaso();
		}
		Utils.println(estudiantes);
	}

	public Map<String, Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Map<String, Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Integer getCantidad_estudiantes() {
		return cantidad_estudiantes;
	}

	public void setCantidad_estudiantes(Integer cantidad_estudiantes) {
		this.cantidad_estudiantes = cantidad_estudiantes;
	}

	public Graph getAmistades() {
		return amistades;
	}

	public void setAmistades(Graph amistades) {
		this.amistades = amistades;
	}
	
}
