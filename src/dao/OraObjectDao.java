package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.OraObject;

public class OraObjectDao {
	private final Connection conn;
	
	public OraObjectDao(Connection conn){
		this.conn = conn;
	}
	
	public List<OraObject> listaOraObjects() throws SQLException{
		List<OraObject> oraObjects = new ArrayList<>();
		
		String sql =  "select object_name "
                    + "  from all_objects "
                    + " where object_type = 'PACKAGE BODY'";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.execute();
			
			try(ResultSet rs = stmt.getResultSet()) {
				while(rs.next()){
					String name = rs.getString("object_name");
				
					String call = "{ ? = call " + name + ".version }";
					
					try(CallableStatement callable = conn.prepareCall(call)){
						callable.registerOutParameter(1, java.sql.Types.INTEGER);
						
						callable.execute();
						
						int version = callable.getInt(1);
					
						OraObject oraObject = new OraObject(name, version);
					
						oraObjects.add(oraObject);
					}
				}
			}	
		}
		
		return oraObjects;
	}
}
