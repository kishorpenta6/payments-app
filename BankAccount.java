public class BankAccount {
	
	private String bankAcctNumber;
	private String bankAcctBankName;
	private String bankAcctIFSC;
	private AcctType bankAcctAcctType;
	private String bankAcctPin;
	
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBankAcctNumber() {
		return bankAcctNumber;
	}
	public void setBankAcctNumber(String bankAcctNumber) {
		this.bankAcctNumber = bankAcctNumber;
	}
	public String getBankAcctBankName() {
		return bankAcctBankName;
	}
	public void setBankAcctBankName(String bankAcctBankName) {
		this.bankAcctBankName = bankAcctBankName;
	}
	public String getBankAcctIFSC() {
		return bankAcctIFSC;
	}
	public void setBankAcctIFSC(String bankAcctIFSC) {
		this.bankAcctIFSC = bankAcctIFSC;
	}
	public AcctType getBankAcctAcctType() {
		return bankAcctAcctType;
	}
	public void setBankAcctAcctType(AcctType bankAcctAcctType) {
		this.bankAcctAcctType = bankAcctAcctType;
	}
	public String getBankAcctPin() {
		return bankAcctPin;
	}
	public void setBankAcctPin(String bankAcctPin) {
		this.bankAcctPin = bankAcctPin;
	}
	
	public String  printBankAccountDetails() {
		return "[" +this.bankAcctNumber+","+this.bankAcctIFSC+ "]";
	}
	
}
