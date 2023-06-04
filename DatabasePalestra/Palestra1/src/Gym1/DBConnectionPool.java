package Gym1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class DBConnectionPool {
	private static List<Connection> freeDBConnections; 
	
	static { 
		freeDBConnections = new LinkedList<Connection>(); 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} 
		catch (ClassNotFoundException e) { 
			System.err.println("DB driver not found!"+ e); 
			System.err.println(e);
		}
	}
	
	public static Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String ip = "localhost";
		String port = "3306";
		String db = "Palestra";
		String username = "root";
		String password = "password";
		String params = "";
		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip +":"+ port +"/"+ db + params,username,password);
		newConnection.setAutoCommit(false);
		
		return newConnection;
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;
		if (! freeDBConnections.isEmpty()) {
			connection = (Connection) freeDBConnections.get(0);
			DBConnectionPool.freeDBConnections.remove(0);
			try {
				if (connection.isClosed())
					connection = DBConnectionPool.getConnection();
			} 
			catch (SQLException e) {
				if(connection != null)
					connection.close();
				connection = DBConnectionPool.getConnection();
			}
		}
		else { 
			connection = DBConnectionPool.createDBConnection(); 
		}
		return connection;
	}
	
	public static synchronized void releaseConnection(Connection connection) {
		DBConnectionPool.freeDBConnections.add(connection);
	}
	
	
}