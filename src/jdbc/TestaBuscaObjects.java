package jdbc;

import java.sql.Connection;
import java.util.List;

import controller.SpecCreator;
import dao.OraObjectDao;
import modelo.ModeloSpec;
import modelo.OraObject;

public class TestaBuscaObjects {

	public static void main(String[] args) {
		try(Connection conn = Database.getConnection()) {
			List<OraObject> oraObjects = new OraObjectDao(conn).listaOraObjects();
			
			for (OraObject oraObject : oraObjects) {
				String specText = new ModeloSpec().buildSpec(oraObject);
				String specName = oraObject.getName().toLowerCase() + "_spec.rb";
				
				new SpecCreator().fileCreator(specText, specName);
			}
		} catch (Exception e) {
			System.out.println("Não conectado");
			e.printStackTrace();
		}
	}

}
