package com.sistema.generadores;

import com.sistema.interfaz.generadores.GeneradorLaminas;
import com.sistema.principal.Propiedades;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GeneradorTabla implements GeneradorLaminas{
	
	private static GeneradorTabla instance;
	private Integer n;
	private ArrayList<Double> probs;
	
	public static  GeneradorTabla getInstance(){
		if(instance == null){
			instance = new GeneradorTabla();
		}
		return instance;
	}
	
	@Override
	public Integer obtenerLamina() {
		if(this.probs == null || this.probs.isEmpty())
			inicializarProbabilidades();

		try {

			do {

				double indexAleatorio = Math.random();

				for (Double d: this.probs) {
					if(d.compareTo(indexAleatorio) >= 0)
						return this.probs.indexOf(d) + 1;
				}

			}while(true);
		}
		 catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setN(Integer n) {
		this.n = n;
		
	}

	private String leerArchivo(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String         line = null;
		StringBuilder  stringBuilder = new StringBuilder();
		String         ls = System.getProperty("line.separator");

		try {
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}

			return stringBuilder.toString();
		} finally {
			reader.close();
		}
	}

	private void inicializarProbabilidades(){
		String nombre = "";
		ArrayList<Double> localProbs = new ArrayList<>();
		try {
			nombre = Propiedades.obtenerPropiedad("nombre_archivo_probabilidades");
			String archivoLeido = leerArchivo( System.getProperty("user.dir") + "/config/tabla/" +  nombre);

			String[] lineas = archivoLeido.split(System.lineSeparator());
			System.out.println(lineas.length);

			if(lineas.length > n)
				throw new RuntimeException("longitud de registros de tabla no conincide con numero de laminillas");

			for (String s: lineas) {
				Double prob = Double.parseDouble(s.split(" ")[1]);
				if(prob > 1 || prob < 0) {
					throw new RuntimeException("Probabilidad de " + s + " invalida");
				}
				localProbs.add(prob);
			}

			this.probs = localProbs;
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("No se encuentra configurada correctamente la propiedad: nombre_archivo_probabilidades");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
