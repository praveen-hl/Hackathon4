package com.vizury.widget;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import ch.boye.httpclientandroidlib.HttpEntity;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.client.ClientProtocolException;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.entity.UrlEncodedFormEntity;
import ch.boye.httpclientandroidlib.client.methods.HttpGet;
import ch.boye.httpclientandroidlib.client.methods.HttpPost;
import ch.boye.httpclientandroidlib.impl.client.HttpClientBuilder;
import ch.boye.httpclientandroidlib.message.BasicNameValuePair;
import ch.boye.httpclientandroidlib.util.EntityUtils;

public class HTTPMethods {
	
	public String getCookie(boolean httpsConnection, String userName, String password, String url) throws ClientProtocolException, IOException{
		String cookie = null;
		
		HttpPost post = new HttpPost(url);
	    List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
	    parameters.add(new BasicNameValuePair("username", userName));
	    parameters.add(new BasicNameValuePair("password", password));
	    post.setEntity(new UrlEncodedFormEntity(parameters));
	    HttpClient httpclient;
	    HttpResponse httpResponse;
	    
		httpclient = (HttpClient) HttpClientBuilder.create().build();
		httpResponse = httpclient.execute(post);			
		cookie = httpResponse.getFirstHeader("set-cookie").getValue().split(";")[0];
		
		return cookie;
	}
	
	public String post(boolean httpsConnection, String userName, String password, String url) throws ClientProtocolException, IOException{
		HttpPost post = new HttpPost(url);
	    List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
	    parameters.add(new BasicNameValuePair("username", userName));
	    parameters.add(new BasicNameValuePair("password", password));
	    post.setEntity(new UrlEncodedFormEntity(parameters));
	    HttpClient httpclient;
	    HttpResponse httpResponse;
	    HttpEntity responseBody;
	    
		httpclient = (HttpClient) HttpClientBuilder.create().build();
		httpResponse = httpclient.execute(post);
		responseBody = httpResponse.getEntity();
		
		return EntityUtils.toString(responseBody);
	}
	
	public String get (boolean httpsConnection, String url, String cookie) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(url);
		get.addHeader("Cookie", cookie);
		HttpClient httpclient;
	    HttpResponse httpResponse;
	    HttpEntity responseBody;
	    
		httpclient = (HttpClient) HttpClientBuilder.create().build();
		httpResponse = httpclient.execute(get);
		responseBody = httpResponse.getEntity();

		return EntityUtils.toString(responseBody);
	}
	

}