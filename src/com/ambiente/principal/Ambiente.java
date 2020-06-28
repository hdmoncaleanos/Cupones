package com.ambiente.principal;

import java.util.HashMap;
import java.util.Map;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import com.sistema.interfaz.generadores.GeneradorLaminas;

public class Ambiente {
	private Integer cantidad_estudiantes;
	private Map<String, Estudiante> estudiantes;
	private GeneradorLaminas generador;
	private Graph amistades;
	
	public Ambiente(Integer cantidad_estudiantes, GeneradorLaminas generador, Integer cantidad_laminas){
		this.generador = generador;
		this.cantidad_estudiantes = cantidad_estudiantes;
		
		estudiantes = new HashMap<String, Estudiante>();
		
		for(int i = 1; i <= cantidad_estudiantes; i++){
			estudiantes.put(i + "", new Estudiante(i + "", cantidad_laminas));
		}
		
		amistades = new SingleGraph("Amistades");
	    Generator gen = new RandomGenerator(2);
	    gen.addSink(amistades);
	    gen.begin();
	    for(int i=0; i<cantidad_estudiantes; i++)
	        gen.nextEvents();
	    gen.end();
	    
	    Iterable<? extends Edge> edges = amistades.getEachEdge();
	    for (Edge edge : edges) {
			System.out.println("Arista : " + edge.getNode0().getId() + " a " + edge.getNode1().getId());
		}
	    int nodes = amistades.getNodeCount();
		int edgesn = amistades.getEdgeCount();
		System.out.println("n: " + nodes + ", M: " + edgesn + " n/M: " + (float) edgesn / (float) nodes );
		amistades.display();
	}
}
