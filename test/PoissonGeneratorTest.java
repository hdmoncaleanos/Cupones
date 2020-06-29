import org.apache.commons.math3.distribution.NormalDistribution;

import com.sistema.generadores.GeneradorBinomial;
import com.sistema.interfaz.generadores.GeneradorLaminas;


public class PoissonGeneratorTest {
	public static void main(String[] args) {
		GeneradorLaminas generador = new GeneradorBinomial();
		generador.setN(100);
		Integer min_lamina = null;
		Integer max_lamina = null;
		for(int i=0;i<10000;i++){
			int nueva_lamina = generador.obtenerLamina();
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
	
	static double obtenerLamina(){
		NormalDistribution distribucion = new NormalDistribution(1, 1);
//		double factor = distribucion.probability(distribucion.getMean() - (3 * distribucion.getStandardDeviation()),
//				distribucion.getMean() + (3 * distribucion.getStandardDeviation()));
//
//		double prob = ((distribucion.sample() * factor)  + (distribucion.getStandardDeviation() * 3)) / (distribucion.getStandardDeviation() * 6);
//
//		if(this.n != null){
//			Integer laminilla = (int) Math.floor(prob * this.n);
////			System.out.println(laminilla);
//			++laminilla;
//			return laminilla;
//		}
		return Math.floor(distribucion.sample());
	}
}
