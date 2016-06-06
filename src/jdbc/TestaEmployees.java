package jdbc;

import java.sql.Connection;
import java.util.List;

import dao.EmployeeDao;
import modelo.Employee;

public class TestaEmployees {

	public static void main(String[] args) {
		try(Connection conn = Database.getConnection()) {
			List<Employee> employees = new EmployeeDao(conn).lista();
			
			for (Employee employee : employees) {
				System.out.println(employee.getName());
				System.out.println(employee.getHiredate());
			}
		} catch (Exception e) {
			System.out.println("Não conectado");
			e.printStackTrace();
		}
	}
}
