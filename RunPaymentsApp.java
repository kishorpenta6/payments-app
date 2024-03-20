import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RunPaymentsApp {

	public static List<User> userList = new ArrayList<User>();
	public static int currUserId = -1;
	public static List<BankAccount> baAcctList = new ArrayList<BankAccount>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int SelectedOption = 0;

		while (true) {
			System.out.println("Please choose an option from below: ");
			System.out.println("1.Registration");
			System.out.println("2.Login");
			System.out.println("3.Add bank account");
			System.out.println("4.Wallet");
			System.out.println("5.List of users");
			System.out.println("6.Current user");
			System.out.println("7.List of users bank accounts");
			System.out.println("8.Delete bank account");
			System.out.println("-1.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an option");
			String op = sc.next();

			try {
				SelectedOption = Integer.parseInt(op);
			} catch (NumberFormatException ne) {
				// ne.printStackTrace();
				System.out.println("This is number format exception");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("This is unknown exception");
			} finally {
				System.out.println();
			}

			UserOperations uop = new UserOperations();

			if (op.equalsIgnoreCase("1")) {
				System.out.println("User selected registartion");
				Registration();
			} else if (op.equalsIgnoreCase("2")) {
				System.out.println("Login");
				Login();
			} else if (op.equalsIgnoreCase("3")) {
				if (validateCurrUser()) {
					System.out.println("Please Enter bank account details: ");
					AddBankAccount();
				}
			} else if (op.equalsIgnoreCase("4")) {
				if (validateCurrUser()) {
					System.out.println("Wallet");
					WalletOperation();
				}
			} else if (op.equalsIgnoreCase("5")) {
				System.out.println("List of users");
				uop.printUsersList(userList);
			} else if (op.equalsIgnoreCase("6")) {
				if (currUserId != -1) {
					System.out.println("Current users");
					uop.printCurrUserDetails(currUserId);
				}
			} else if (op.equalsIgnoreCase("7")) {
				if (currUserId != -1) {
					System.out.println("List of users bank accounts");
					printUserBankAccounts();
				}
			} else if (op.equalsIgnoreCase("8")) {
				if (currUserId != -1) {
					System.out.println("Delete bank account");
					System.out.println("Enter Bank Account Number: ");
					String accNum = sc.next();
					deleteUserBankAccount(currUserId, accNum, userList);
				} else {
					System.out.println("please login to delete bank accounts");
				}
			} else if (op.equalsIgnoreCase("-1")) {
				System.out.println("Exit");
				break;
			} else {
				System.out.println("Enter a valid Option!!! \n");

			}
		}
	}

	public static void Registration() {
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();
		System.out.println("First Name: ");
		String fname = sc.next();
		System.out.println("Last Name: ");
		String lname = sc.next();
		System.out.println("Phone Number: ");
		long phnum = sc.nextLong();
		System.out.println("Date of Birth: ");
		String dob = sc.next();
		System.out.println("Address: ");
		String addr = sc.next();
		System.out.println("Password: ");
		String pswd = sc.next();

		User u;
		try {
			u = uop.doUserRegistration(fname, lname, phnum, dob, addr, pswd);
			// userList.add(u);
			PaymentAppCliDAO dao = new PaymentAppCliDAO();
			dao.storeUserDetails(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean Login() {
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();

		System.out.println("Enter Your User ID: ");
		String uId = sc.next();
		System.out.println("Enter Your Password: ");
		String pswd = sc.next();

		if (uop.verifyUserLogin(uId, pswd)) {
			currUserId = Integer.parseInt(uId);
			return true;
		} else {
			System.out.println("Login Failed, please try again!!");
			return false;
		}

	}

	public static boolean validateCurrUser() {
		if (currUserId != -1) {
			return true;
		} else {
			return false;
		}
	}

	public static void AddBankAccount() {
		AcctType selectedAcctType = null;
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();

		System.out.println("Bank Account Number: ");
		String baAcctNum = sc.next();
		System.out.println("Bank IFSC Code: ");
		String baIFSCCode = sc.next();
		System.out.println("Bank Name: ");
		String baName = sc.next();
		System.out.println("Bank Account Type: ");
		System.out.println("SA: SAVINGS");
		System.out.println("CA: CURRENT");
		System.out.println("LA: LOAN");
		System.out.println("SL: SALARY");
		String baAcctType = sc.next();

		if (baAcctType.equalsIgnoreCase("SA")) {
			// System.out.println(AcctType.SAVINGS);
			selectedAcctType = AcctType.SAVINGS;

		} else if (baAcctType.equalsIgnoreCase("CA")) {
			// System.out.println(AcctType.CURRENT);
			selectedAcctType = AcctType.CURRENT;
		} else if (baAcctType.equalsIgnoreCase("LA")) {
			// System.out.println(AcctType.LOAN);
			selectedAcctType = AcctType.LOAN;
		} else if (baAcctType.equalsIgnoreCase("SL")) {
			// System.out.println(AcctType.SALARY);
			selectedAcctType = AcctType.SALARY;
		} else {
			System.out.println("Enter Valid Account Type Option");
		}

		System.out.println("Bank Account Pin: ");
		String baAcctPin = sc.next();

		BankAccount ba = new BankAccount();
		ba.setBankAcctNumber(baAcctNum);
		ba.setBankAcctIFSC(baIFSCCode);
		ba.setBankAcctBankName(baName);
		ba.setBankAcctType(selectedAcctType);
		ba.setBankAcctPin(baAcctPin);
		ba.setUserId(currUserId);

		for (User u : userList) {
			if (u.getUserId() == currUserId) {
				u.getBaList().add(ba);
			}
		}
		baAcctList.add(ba);
	}

	public static void printUserBankAccounts() {
		UserOperations uop = new UserOperations();
		Map<User, List<BankAccount>> mapItems = uop.getUsersBankAccount();

		for (User u : mapItems.keySet()) {
			List<BankAccount> baList = mapItems.get(u);
			System.out.println(u);
			if (baList != null) {
				for (BankAccount ba : baList) {
					System.out.println("--" + ba.printBankAcctDetails());
				}
			}

		}
	}

	public static void deleteUserBankAccount(int UserId, String accNum, List<User> userlist) {
		for (User u : userlist) {
			if (u.getUserId() == UserId) {
				List<BankAccount> baAcctList = u.getBaList();
				Iterator<BankAccount> iterator = baAcctList.iterator();
				while (iterator.hasNext()) {
					BankAccount acct = iterator.next();
					if (acct.getBankAcctNumber().equals(accNum)) {
						iterator.remove();
						System.out.println("BankAccount deleted successfully");
						return;
					}
				}
			}
		}
		System.out.println("Bank Account has Not matched");
	}

	public static void WalletOperation() {

		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();
		int Balance = 0;
		int Deposit = 0;
		int Withdraw = 0;
		// int password=1234;
		int pin = 0;

		while (true) {
			System.out.println("Please choose an option: ");

			System.out.println("1.Check Balance ");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Transaction History");
			System.out.println("5.EXIT \n");

			System.out.println("Enter your option :");

			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("Your current Balance is : " + Balance + "\n");
				break;

			case 2:
				System.out.println("Enter an amount to Deposit: ");
				Deposit = sc.nextInt();
				Balance = Deposit + Balance;
				System.out.println("Your current Balance is : " + Balance);
				break;

			case 3:
				System.out.println("Enter an amount to Withdraw: ");
				Withdraw = sc.nextInt();
				if (Balance > Withdraw) {
					Balance = Balance - Withdraw;
					System.out.println("Your current Balance is : " + Balance);
				} else {
					System.out.println("Your current balance is Unable to Withdraw!");
				}
				break;

			case 4:
				System.out.println("Your last transactioin history : ");
				System.out.println("Last time added desposited amount : " + Deposit);
				System.out.println("Last time taken withdrawal amount : " + Withdraw);
				System.out.println("Your current available Balance is : " + Balance + "\n");
				break;
			case 5:
				System.out.println("Thanks You!! \n");
				break;

			default:
				System.out.println("Enter valid Option!!");
			}
			if (opt == 5) {
				break;
			}
		}
	}
}
