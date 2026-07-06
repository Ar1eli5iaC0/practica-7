package conexion_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion implements parametrizable{
	protected Connection conn=null;
	protected Statement stmt=null;
	protected ResultSet res=null;
	public Connection abrir() {
		try {
			Class.forName(driver);
			this.conn=DriverManager.getConnection(getURL());
			if(conn!=null)
				System.out.println("conexion exitosa");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en el driver"+e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en el URL "+e);
		}
		return conn;
	}
	public boolean cerrar() {
		try {
			if(conn!=null) {
				conn.close();
				if(stmt!=null)
					stmt.close();
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error el cerrar: "+e);
			return false;
		}
	}
}
