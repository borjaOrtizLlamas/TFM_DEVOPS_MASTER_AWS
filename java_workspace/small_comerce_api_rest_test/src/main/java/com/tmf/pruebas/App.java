package com.tmf.pruebas;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tfm.dto.Client;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();


		Client client = new Client(); 
		client.setName("xe60693");
		client.setPhone("639717");
		client.setSurname("ortiz");

		
		
		JSONObject jsonObject = new JSONObject(client); 
		try {
			//post
			HttpPost requestPost = new HttpPost("http://localhost:90/client");
			StringEntity params = new StringEntity(jsonObject.toString());
			requestPost.addHeader("content-type", "application/json");
			requestPost.setEntity(params);
			httpClient.execute(requestPost);

			HttpGet requestGet = new HttpGet("http://localhost:90/client/"+client.getName());
			CloseableHttpResponse response =  httpClient.execute(requestGet); 
	        StatusLine statusLine = response.getStatusLine();
	        System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
	        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
	        System.out.println("Response body: " + responseBody);
	        JSONObject jsonObjectString = new JSONObject(responseBody);

	        //viendo si la respuesta es igual
	        if(!jsonObject.similar(jsonObjectString)) {
	        	System.out.println("Response body must be:" + jsonObject);
	        	throw new Exception("Response is not the same than the post, create client have errors "); 
	        }; 



	        CloseableHttpClient httpClient2 = HttpClientBuilder.create().build();

	        System.out.println("Anadiendo producto");
			
		
			List lista = new ArrayList<>(); 
			lista.add(client); 
			JSONArray prueba = new JSONArray(lista); 
	        System.out.println("http://localhost:90/client/"+client.getName()); 
			HttpPost requestPost2 = new HttpPost("http://localhost:90/client/"+client.getName());
			CloseableHttpResponse responsPost = httpClient2.execute(requestPost2); 
	        System.out.println("despues llamada de productos" + responsPost);

			HttpGet requestGet2 = new HttpGet("http://localhost:90/client");
			CloseableHttpResponse response2 =  httpClient2.execute(requestGet2); 
	        StatusLine statusLine2 = response2.getStatusLine();
	        System.out.println(statusLine2.getStatusCode() + " " + statusLine2.getReasonPhrase());
	        String responseBody2 = EntityUtils.toString(response2.getEntity(), StandardCharsets.UTF_8);
	        JSONArray jsonObjectString2 = new JSONArray(responseBody2);
	        System.out.println("Response body  must to be----> " + prueba);
	        //viendo si la respuesta es igual
	        if(!prueba.similar(jsonObjectString2)) {
	        	throw new Exception("Response is not the same than the post, the adding clients have failled"); 
	        }; 
	        
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				throw e; 
			}
		}
	}
}