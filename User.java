import java.util.ArrayList;
import java.util.List;

public class User extends Object{

	private String firstName; 
	private String lastName;
	private long phoneNumber;
	private String dateOfBirth;
	private  String address;
    
	private  int userId;
	private String password;
	
	private List<BankAccount> baList = new ArrayList<BankAccount>();
	
	
	
	public List<BankAccount> getBaList() {
		return baList;
	}
	public void setBaList(List<BankAccount> baList) {
		this.baList = baList;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return this.userId+" : "+this.firstName+" : "+this.lastName+" : "+this.phoneNumber+" : "+this.dateOfBirth+" : "+this.address;
	}
	public String userToFileRecord() {
		return this.userId+","+ this.firstName +","+ this.lastName + ","+this.phoneNumber+","+this.dateOfBirth+","+this.address+"\n";
	}
}
	
	
	
