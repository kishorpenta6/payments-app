public class BankAccount {

	private String bankAcctNumber;
	private String bankAcctIFSC;
	private String bankAcctBankName;
	private AcctType bankAcctType;
	private String bankAcctPin;

	private int UserId;

	public String getBankAcctNumber() {
		return bankAcctNumber;
	}

	public void setBankAcctNumber(String bankAcctNumber) {
		this.bankAcctNumber = bankAcctNumber;
	}

	public String getBankAcctIFSC() {
		return bankAcctIFSC;
	}

	public void setBankAcctIFSC(String bankAcctIFSC) {
		this.bankAcctIFSC = bankAcctIFSC;
	}

	public String getBankAcctBankName() {
		return bankAcctBankName;
	}

	public void setBankAcctBankName(String bankAcctBankName) {
		this.bankAcctBankName = bankAcctBankName;
	}

	public AcctType getBankAcctType() {
		return bankAcctType;
	}

	public void setBankAcctType(AcctType bankAcctType) {
		this.bankAcctType = bankAcctType;
	}

	public String getBankAcctPin() {
		return bankAcctPin;
	}

	public void setBankAcctPin(String bankAcctPin) {
		this.bankAcctPin = bankAcctPin;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String printBankAcctDetails() {
		return "[" + this.bankAcctNumber + "," + this.bankAcctIFSC + "," + this.bankAcctBankName + ","
				+ this.bankAcctType + "," + this.bankAcctPin + "]";
	}
}
