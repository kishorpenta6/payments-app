
public class Wallet {
	
	private int UserId;
	private double balance;
	private double walletAmountLimit =10000;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getWalletAmountLimit() {
		return walletAmountLimit;
	}
	public void setWalletAmountLimit(double walletAmountLimit) {
		this.walletAmountLimit = walletAmountLimit;
	}
	
	
}
