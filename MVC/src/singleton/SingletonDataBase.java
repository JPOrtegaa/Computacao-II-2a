package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonDataBase {
		
	private static SingletonDataBase instance=null;

	protected Connection db = null;
	protected Statement stmt = null;

	
	private SingletonDataBase () {
		connect();
	}
	
	public static SingletonDataBase getInstance () {
		if (instance==null)  instance = new SingletonDataBase();
		return instance;		
	}
	
	public Statement getStatement() {
		return stmt;
	}
	
	protected void connect() {
		String db_connect_string = "jdbc:mysql://localhost:3306/prova3"+
								   "?allowPublicKeyRetrieval=true"+
								   "&useSSL=false";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (this.db != null)
				this.db.close();
			db = DriverManager.getConnection( db_connect_string, "root",
					"jp17" ); 
			createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void createStatement() throws SQLException {
		if (this.stmt != null)
			this.stmt.close();

		stmt = db.createStatement();
	}
	
	public static void main(String[] args) {
		SingletonDataBase.getInstance();
	}

}
