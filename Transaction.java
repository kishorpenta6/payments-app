public class Transaction {

	private int txnId;
	private String dateTime;
	private String Limit;
	private String txnSource;
	private String txnDestination;
	private double amount;
	private String statement;
	
	
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getLimit() {
		return Limit;
	}
	public void setLimit(String limit) {
		Limit = limit;
	}
	public String getTxnSource() {
		return txnSource;
	}
	public void setTxnSource(String txnSource) {
		this.txnSource = txnSource;
	}
	public String getTxnDestination() {
		return txnDestination;
	}
	public void setTxnDestination(String txnDestination) {
		this.txnDestination = txnDestination;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	
}
