package logico;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private String id;
	private Date date;
	private String RNC; //OPTIONAL
	private boolean taxCredit;
	private String clientId;
	private String empId;
	private ArrayList<Product> products;
	private float total;
	private String payMethod; // CASH, CREDIT, CARD or TRANSFER
	
	public Order(String id, Date date, String RNC, boolean taxCredit, String clientId, String empId,
			ArrayList<Product> products, float total, String payMethod) {
		super();
		this.id = id;
		this.date = date;
		this.RNC = RNC;
		this.taxCredit = taxCredit;
		this.clientId = clientId;
		this.empId = empId;
		this.products = products;
		this.total = total;
		this.payMethod = payMethod;
	}
	
	public Order(String id, Date date, boolean taxCredit, String clientId, String empId,
			ArrayList<Product> products, float total, String payMethod) {
		super();
		this.id = id;
		this.date = date;
		this.taxCredit = taxCredit;
		this.clientId = clientId;
		this.empId = empId;
		this.products = products;
		this.total = total;
		this.payMethod = payMethod;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRNC() {
		return RNC;
	}

	public void setRNC(String rNC) {
		this.RNC = rNC;
	}

	public boolean isTaxCredit() {
		return taxCredit;
	}

	public void setTaxCredit(boolean taxCredit) {
		this.taxCredit = taxCredit;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getId() {
		return id;
	}

}


