package demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnectionJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("db.url");
        String login = properties.getString("db.login");
        String pwd = properties.getString("db.password");
       
        try (Connection connection = DriverManager.getConnection(url, login, pwd)){
            System.out.println(connection);
            System.out.println("connected");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
	}

}
