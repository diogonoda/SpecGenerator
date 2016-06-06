package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Employee;

public class EmployeeDao {
	private final Connection conn;
	
	public EmployeeDao(Connection conn){
		this.conn = conn;
	}
	
	public List<Employee> lista() throws SQLException{
		List<Employee> employees = new ArrayList<>();
		
		String sql = "select * from employees";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.execute();
			
			try(ResultSet rs = stmt.getResultSet()) {
				while(rs.next()){
					int id = rs.getInt("emp_id");
					String name = rs.getString("emp_name");
					float salary = rs.getFloat("emp_salary");
					Date hiredate = rs.getDate("emp_hiredate");
					int deptId = rs.getInt("emp_dept_id");
					
					Employee employee = new Employee(id, name, salary, hiredate, deptId);
					
					employees.add(employee);
				}
			}
		}
		
		return employees;
	}
}
