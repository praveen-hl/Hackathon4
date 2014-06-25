package model;

import java.util.Arrays;

public class UserInfo {
	private String status;
	private Result results;
	public UserInfo(String status, Result results){
		this.status = status;
		this.results = results;
	}
	
	public String getStatus() {
		return status;
	}

	public Result getResults() {
		return results;
	}

	@Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("status="+getStatus()+"\n");
        sb.append("username="+results.getUsername()+"\n");
        sb.append("role="+results.getRole()+"\n");
        sb.append("products="+Arrays.toString(results.getProducts().toArray())+"\n");
        sb.append("campaign list="+Arrays.toString(results.getCampList().toArray())+"\n");
        sb.append("measures="+Arrays.toString(results.getMeasures().toArray())+"\n");
        sb.append("isCBPEnabled="+results.isCBPEnabled()+"\n");
        sb.append("*****************************");
        return sb.toString();
     }

}
