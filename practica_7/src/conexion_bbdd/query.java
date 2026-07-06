package conexion_bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class query extends conexion{
	// consultar a la base de datos
	public ResultSet getQuerty(String sql) {
		try {
			stmt=(Statement)abrir().createStatement();
			res=stmt.executeQuery(sql);
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al consultar "+e);
			return null;
		}
		
	}
	//metodo para insertar, actualizar y borrar
	public boolean setQuerry(String sql) {
		try {
			stmt=(Statement)abrir().createStatement();
			stmt.executeUpdate(sql);
			return cerrar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al operacion sql"+e);
			return false;
		}	}
}
