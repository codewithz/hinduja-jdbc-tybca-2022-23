import java.sql.*;
import java.time.LocalDate;


public class SelectEmployee {
	
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
			
			String query="Select id,name,email,phone,date_of_joining"
					+ " from employee";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				long phone=rs.getLong("phone");
				LocalDate date=LocalDate.parse(rs.getString("date_of_joining"));
				
				System.out.println("--------------------------------------");
				System.out.println("ID:"+id);
				System.out.println("Name:"+name);
				System.out.println("Email:"+email);
				System.out.println("Phone:"+phone);
				System.out.println("Date of Joining:"+date);
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
