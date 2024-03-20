import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentAppCliDAO {

	public static void storeUserDetails(User u) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String storeUserDetailsQuery = "insert into User_info(First_Name,Last_Name,Phone_Number,Date_Of_Birth,Address,Password) "
					+ "values('" + u.getFirstName() + "','" + u.getLastName() + "','" + u.getPhoneNumber() + "','"
					+ u.getDateOfBirth() + "','" + u.getAddress() + "','" + u.getPassword() + "')";

			int rs = st.executeUpdate(storeUserDetailsQuery);
			System.out.println(rs + "row/s effected");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printUserDetails() throws SQLException {
		User u = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String printUserDetailsQuery = "select * from User_info";
			ResultSet rs = st.executeQuery(printUserDetailsQuery);
			while (rs.next()) {
				System.out.println(
						rs.getInt("Id") + " : " + rs.getString("First_Name") + " : " + rs.getString("Last_Name") + " : "
								+ rs.getLong("Phone_Number") + " : " + rs.getString("Date_Of_Birth") + " : "
								+ rs.getString("Address") + " : " + rs.getString("Password"));
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean verifyUserLogin(int uId, String pswd) throws SQLException {
		User u = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String verifyUserLoginQuery = "select Id,Password from User_info where Id = '" + u.getUserId()
					+ "'and Password ='" + u.getPassword() + "'";
			ResultSet rs = st.executeQuery(verifyUserLoginQuery);
			
			boolean	LoginUser = rs.next();
			RunPaymentsApp.currUserId = uId;
				System.out.println("Login successful!");
				st.close();
				con.close();
				return LoginUser;
				
//			while (rs.next()) {
////				if (Integer.valueOf(u.getUserId())==uId) {
////					if(pswd.equals(u.getPassword())){
//				if (rs.equals(uId)) {
//					if (rs.equals(pswd)) {
//						// RunPaymentsApp.currUserId = uId;
//						System.out.println("Login Successfull!");
//						return true;
//					}
//				}
//				// System.out.println("Login Failed!");
//			}
//			System.out.println("Login Failed!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void storeUserBankAcctDetails(BankAccount ba) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String storeUserBankAcctDetailsQuery = "insert into BankAccount_Details(Account_Number,Acct_IFSC,Bank_Name,Bank_Acct_Pin,Acct_Type,UserId) "
					+ "values('" + ba.getBankAcctNumber() + "','" + ba.getBankAcctIFSC() + "','"
					+ ba.getBankAcctBankName() + "','" + ba.getBankAcctType() + "','" + ba.getBankAcctPin() + "')";

			int rs = st.executeUpdate(storeUserBankAcctDetailsQuery);
			System.out.println(rs + "row/s effected");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void printUserBankAcctDetails(BankAccount ba) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String printUserBankAcctDetailsQuery = "SELECT * FORM BankAccount_Details";
			ResultSet rs = st.executeQuery(printUserBankAcctDetailsQuery);

			while (rs.next()) {
				System.out.println(
						rs.getInt("Id") + " : " + rs.getString("Account_Number") + " : " + rs.getString("Acct_IFSC")
								+ " : " + rs.getLong("Bank_Name") + " : " + rs.getString("Bank_Acct_Pin") + " : "
								+ rs.getString("Acct_Type") + " : " + rs.getString("User_Id"));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

