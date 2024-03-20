import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOperations {
	
	public List<User> users=null;
	public List<BankAccount> baAcctList=null;
	public Map<Integer,Wallet> walletList=null;
	
	public UserOperations() {
		users = RunPaymentsApp.userList;
		baAcctList = RunPaymentsApp.baAcctList;
		walletList=RunPaymentsApp.walletList;
	}
	public User doUserRegistration(String fname,String lname,long phnum,String dob,String addr,String pswd) {
		User u = new User();
		u.setFirstName(fname);
		u.setLastName(lname);
		u.setPhoneNumber(phnum);
		u.setDateOfBirth(dob);
		u.setAddress(addr);
		u.setPassword(pswd);
		
		u.setUserId((int)(Math.random()*1000)+100); 
		
		return u;
	}
	
//	public void printUsersList(List<User> users) {
//		for(User u:users) {
//			if(users!=null) {
//				System.out.println("User Details of : "+u.getFirstName());
//				System.out.println(u);
//			}
//		}
//	}
	
//	public boolean verifyUserLogin(String uId,String pswd) {
//		for(int i=0;i<users.size();i++) {
//			if(String.valueOf(users.get(i).getUserId()).equals(uId)) {
//				if(pswd.equals(users.get(i).getPassword())) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
	public void printCurrUserDetails(int UserId) {
		for(User u:users) {
			if(u.getUserId()==UserId) {
				System.out.println(u);
			}
			else {
				System.out.println("No user logged in");
			}
		}
	}
	
	public Map<User,List<BankAccount>> getUsersBankAccount(){
		
		Map<User,List<BankAccount>> userBankAcctMap = new HashMap<User,List<BankAccount>>();
		
		for(User u :users) {
			if(users!=null) {
				userBankAcctMap.put(u,u.getBaList());
			}
		}
		return userBankAcctMap;
	}
	
	public boolean verifyUserBankAccount(String bankAcctNumber,String pin) {
		for(int i=0;i<baAcctList.size();i++) {
			if(String.valueOf(baAcctList.get(i).getBankAcctNumber()).equals(bankAcctNumber)) {
				if(pin.equals(baAcctList.get(i).getBankAcctPin())) {
					baAcctList.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public void addMoneyToWallet(double amount) {
		if(walletList.containsKey(RunPaymentsApp.currUserId)) {
			walletList.get(RunPaymentsApp.currUserId).setBalance(walletList.get(RunPaymentsApp.currUserId ).getBalance()+amount);
	        System.out.println("Current wallet Balance: "+walletList.get(RunPaymentsApp.currUserId ).getBalance());
		}
	}
	
	public double checkWalletBalance() {
		return walletList.get(RunPaymentsApp.currUserId ).getBalance();
	}

}
