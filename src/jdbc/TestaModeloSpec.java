package jdbc;

import modelo.ModeloSpec;
import modelo.OraObject;

public class TestaModeloSpec {
	public static void main(String[] args) {
		OraObject oraObject = new OraObject("PC_EMPLOYEES", 3);
		
		String teste = new ModeloSpec().buildSpec(oraObject);
		
		System.out.println(teste);
	}
}
