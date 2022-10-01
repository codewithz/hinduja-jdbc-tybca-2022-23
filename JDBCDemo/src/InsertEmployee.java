import java.sql.*;
import java.time.*;


public class InsertEmployee {
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/hinduja_ty_2022_23";
		String user="root";
		String password="admin";
		
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Succesfully.");
			con=DriverManager.getConnection(url, user, password);
			System.out.println("Connection is established.");
			
			String name="Mike";
			String email="mike@gmail.com";
			long phone=9988775699L;
			LocalDate dateOfJoining=LocalDate.of(2018, 10, 9);
			
			String query="Insert into employee (name,email,phone,date_of_joining)"
					+ " values(?,?,?,?);";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setLong(3, phone);
			pstmt.setString(4, String.valueOf(dateOfJoining));
			
			int rowInserted=pstmt.executeUpdate();
			
			System.out.println("Rows Inserted :"+rowInserted);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
