import java.sql.*;


public class TestConnection {
	
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
