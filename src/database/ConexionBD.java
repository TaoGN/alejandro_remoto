/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.Cliente;

/**
 * @author Alejandro García
 */
public class ConexionBD {
	private String database_name = "pizzeria";
	private String user = "root";
	private String password = "alejandro1992";
	private String url = "jdbc:mysql://localhost:3306/" + "pizzeria";
	Connection conn = null;
	
	public Connection getConnection() {
		try {
			//Obtenemos el valor del driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtenemos la conexion
			conn = DriverManager.getConnection(url,user,password);		
		}catch(ClassNotFoundException e) {
			System.err.println("Ha ocurrido un error de clase"+e.getMessage());			
		}catch(SQLException e) {
			System.err.println("Ha ocurrido un error sql"+e.getMessage());	
		}catch(Exception e) {
			System.err.println("Error general"+e.getMessage());
		}
		return conn;
	}
	
    public void insertarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO clientes (nombre, apellidos, fechaDeAlta, telefono, direccion, historial) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidos());
            stmt.setDate(3, new java.sql.Date(cliente.getFechaDeAlta().getTime()));
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getHistorial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar el cliente en la base de datos: " + e.getMessage());
            System.err.println("Consulta SQL: " + sql);
            System.err.println("Valores: " + cliente);
        } finally {
            close(stmt);
            close(conn);
        }
    }

    public Cliente consultarClientePorTelefono(String telefono) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            conn = getConnection();
            String sql = "SELECT * FROM clientes WHERE telefono = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefono);
            rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setFechaDeAlta(rs.getDate("fechaDeAlta"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setHistorial(rs.getString("historial"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el cliente en la base de datos: " + e.getMessage());
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return cliente;
    }
    
    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void close(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
        }
    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar el ResultSet: " + e.getMessage());
            }
        }
    }
}
