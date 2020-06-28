import com.ambiente.principal.Estudiante;
import com.simulador.utils.Utils;


public class CambioLaminasTest {
	public static void main(String[] args) {
		Estudiante estudiante1 = new Estudiante("1", 10);
		Estudiante estudiante2 = new Estudiante("2", 10);
		estudiante1.agregarLaminaComprada(1);
		estudiante1.agregarLaminaComprada(2);
		estudiante1.agregarLaminaComprada(3);
		estudiante1.agregarLaminaComprada(4);
		estudiante1.agregarLaminaComprada(5);
		estudiante1.agregarLaminaComprada(1);
		estudiante1.agregarLaminaComprada(2);
		
		estudiante2.agregarLaminaComprada(6);
		estudiante2.agregarLaminaComprada(7);
		estudiante2.agregarLaminaComprada(8);
		estudiante2.agregarLaminaComprada(9);
		estudiante2.agregarLaminaComprada(10);
		estudiante2.agregarLaminaComprada(6);
		estudiante2.agregarLaminaComprada(7);
		
		Utils.println(estudiante1);
		Utils.println(estudiante2);
		
		estudiante1.intercambiarLaminas(estudiante2);

		Utils.println(estudiante1);
		Utils.println(estudiante2);
	}
}
