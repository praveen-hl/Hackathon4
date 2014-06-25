package com.vizury.widget;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import model.Dashboard;
import model.UserInfo;

import com.google.gson.Gson;

public class VizuryCentral {
	public static void main (String[] args) throws ClientProtocolException, IOException{
		VizuryCentral vc = new VizuryCentral();
		System.out.println(vc.dataRetriever());
	}
	
	public String dataRetriever() throws ClientProtocolException, IOException{
		
		String data = null;
		
		String loginURL = "http://ec2-54-254-28-169.ap-southeast-1.compute.amazonaws.com:3000/-/api/login";
		String userInfo = "http://ec2-54-254-28-169.ap-southeast-1.compute.amazonaws.com:3000/-/api/webConvert/user-info";
		String userName = "test_mayuki";
		String password = "tested";
		Gson gson = new Gson();
		HTTPMethods http = new HTTPMethods();
		
		String cookie = http.getCookie(false, userName, password, loginURL);
		
		String json = http.get(false, userInfo, cookie);
		UserInfo uinfo = gson.fromJson(json, UserInfo.class);
		String adSpend = uinfo.getResults().getMeasures().toArray()[5].toString();
		
		String product = uinfo.getResults().getProducts().toArray()[0].toString();
		String campaign = uinfo.getResults().getCampList().toArray()[0].toString();
		String dashboardURL = "http://ec2-54-254-28-169.ap-southeast-1.compute.amazonaws.com:3000/-/api/"+product+"/campaign/"+campaign+"/dashboard";
		json = http.get(false, dashboardURL, cookie);
		
		Dashboard db = gson.fromJson(json, Dashboard.class);

		
		System.out.println("Campaign Name: "+campaign);
		System.out.println("Date: "+db.getRows().get(db.getRows().size()-1).toArray()[0]);
		System.out.println("Impressions: "+db.getRows().get(db.getRows().size()-1).toArray()[1]);
		System.out.println("Conversions: "+db.getRows().get(db.getRows().size()-1).toArray()[3]);
		System.out.println(adSpend+": "+db.getRows().get(db.getRows().size()-1).toArray()[4]);
		
		data = "Campaign Name: "+campaign+"\n"+"Date: "+db.getRows().get(db.getRows().size()-1).toArray()[0]+"\n"+"Impressions: "+db.getRows().get(db.getRows().size()-1).toArray()[1]+"\n"+"Conversions: "+db.getRows().get(db.getRows().size()-1).toArray()[3]+"\n"+adSpend+": "+db.getRows().get(db.getRows().size()-1).toArray()[4];
				
		return data;
		
	}

}
