package section3;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.github.dockerjava.api.model.Driver;

public class modifythedatabase {

	public static void main(String[] args) throws SQLException {
		//Step 1: Create an instance of JDBC Driver
		Driver dbDriver = new Driver();
		//Step 2: Register Driver
		DriverManager.registerDriver(dbDriver);
		//Step 3: Establish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
		//Step 4: Create 

	}

}
