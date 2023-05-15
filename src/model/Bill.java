package model;

public class Bill {
	private int invoiceNo;
	private String Total_charge;
	private String Payment_status;
	private String Bill_date;

	public Bill() {
		this.invoiceNo = 0;
		Total_charge = "";
		Payment_status = "";
		Bill_date = "";
	}

	public Bill(int invoiceNo, String total_charge, String payment_status, String bill_date) {
		super();
		this.invoiceNo = invoiceNo;
		Total_charge = total_charge;
		Payment_status = payment_status;
		Bill_date = bill_date;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getTotal_charge() {
		return Total_charge;
	}

	public void setTotal_charge(String total_charge) {
		Total_charge = total_charge;
	}

	public String getPayment_status() {
		return Payment_status;
	}

	public void setPayment_status(String payment_status) {
		Payment_status = payment_status;
	}

	public String getBill_date() {
		return Bill_date;
	}

	public void setBill_date(String bill_date) {
		Bill_date = bill_date;
	}

	@Override
	public String toString() {
		return "Bill [invoiceNo=" + invoiceNo + ", Total_charge=" + Total_charge + ", Payment_status=" + Payment_status
				+ ", Bill_date=" + Bill_date + "]";
	}

}
