package com.simulador.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sistema.objetos.Resultado;

public class Utils {
	public static void println(Object o) {

		if (o == null) {
			System.out.println("null");
			return;
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		System.out.println(gson.toJson(o));
	}	
}
