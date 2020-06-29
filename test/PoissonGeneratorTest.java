import com.sistema.generadores.GeneradorGeometrica;
import com.sistema.generadores.GeneradorPoisson;
import com.sistema.interfaz.generadores.GeneradorLaminas;


public class PoissonGeneratorTest {
	public static void main(String[] args) {
		GeneradorLaminas generador = new GeneradorGeometrica();
		generador.setN(2);
		Integer min_lamina = null;
		Integer max_lamina = null;
		for(int i=0;i<200;i++){
			Integer nueva_lamina = generador.obtenerLamina();
			if(min_lamina == null){
				min_lamina = nueva_lamina;
			}
			if(max_lamina == null){
				max_lamina = nueva_lamina;
			}
			
			if(nueva_lamina < min_lamina){
				min_lamina = nueva_lamina;
			}
			if(nueva_lamina > max_lamina){
				max_lamina = nueva_lamina;
			}
			
			
		}
		System.out.println(max_lamina + " " + min_lamina);
	}
}
