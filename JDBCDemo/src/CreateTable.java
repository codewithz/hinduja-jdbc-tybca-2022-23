import java.sql.*;


public class CreateTable {
	
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
			
			String query="Create table employee"
					+ "(id int primary key auto_increment,"
					+ "name varchar(100),"
					+ "email varchar(100),"
					+ "phone bigint,"
					+ "date_of_joining date)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			boolean result=pstmt.execute();
			
			if(!result) {
				System.out.println("Table Created Successfully");
			}
			
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
