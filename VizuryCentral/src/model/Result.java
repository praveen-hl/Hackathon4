package model;

import java.util.List;

public class Result {
	
	private String username;
	private String role;
	private List<String> products;
	private List<String> campList;
	private List<String> measures;
	private boolean isCBPEnabled;
	
	public Result(String username, String role, List<String> products){
		this.username = username;
		this.role = role;
		this.products = products;
	}
	
	public Result(String username, String role, List<String> products, List<String> campList, List<String> measures, boolean isCBPEnabled){
		this.username = username;
		this.role = role;
		this.products = products;
		this.campList = campList;
		this.measures = measures;
		this.isCBPEnabled = isCBPEnabled;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public List<String> getProducts() {
		return products;
	}
	
	public List<String> getCampList() {
		return campList;
	}

	public List<String> getMeasures() {
		return measures;
	}

	public boolean isCBPEnabled() {
		return isCBPEnabled;
	}
	
	@Override
    public String toString(){
        return "Username:" +getUsername()+"\nrole:"+getRole()+"\nproducts:"+getProducts();
    }




}
