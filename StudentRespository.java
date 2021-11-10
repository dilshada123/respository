
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DbUtil.java;

public class StudentRepository {
	private Connection dbConnection;
	
	public StudentRepository() {
		dbConnection = DbUtil.getConnection();
	}
	
	public void save(String first_name, String last_name, String date_of_birth, String email_ID, String contact_number) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("insert into student(userName, password, firstName, lastName, dateOfBirth, emailAddress) values (?, ?, ?, ?, ?, ?)");
			prepStatement.setString(1, first_name);
			prepStatement.setString(2, last_name);
      	prepStatement.setDate(3, new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy")
			.parse(date_of_birth.substring(0, 10)).getTime()));
			prepStatement.setString(4, email_ID);
			prepStatement.setString(5, contact_number);

			
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	}
}
