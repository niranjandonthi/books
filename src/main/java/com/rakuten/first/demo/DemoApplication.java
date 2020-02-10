
package com.rakuten.first.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.rakuten.first.demo.dal.BookDAO;
//import com.rakuten.first.demo.dal.PublisherDAO;
import com.rakuten.first.demo.service.BookService;
import com.rakuten.first.demo.ui.BookConsoleUI;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Configuration
public class DemoApplication {

	private static Object inline;

	public static void main(String[] args) throws IOException {
		
		ApplicationContext springContainer = 
		SpringApplication.run(DemoApplication.class, args);
//	    BookConsoleUI ui = springContainer.getBean(BookConsoleUI.class);
//	    ui.createBookWithUI();
//	    BookService bookservice = springContainer.getBean(BookService.class);
//	    BookDAO bookdao = springContainer.getBean(BookDAO.class);
//	    PublisherDAO pub = springContainer.getBean(PublisherDAO.class);
//		 String url = ("https://api.github.com/users/hadley/orgs");
//	     URL obj = new URL(url);
//	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//	     // optional default is GET
//	     con.setRequestMethod("GET");
//	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
//	     int responseCode = con.getResponseCode();
//	     System.out.println("\nSending 'GET' request to URL : " + url);
//	     System.out.println("Response Code : " + responseCode);
//	     BufferedReader in = new BufferedReader(
//	             new InputStreamReader(con.getInputStream()));
//	     String inputLine;
//	     StringBuffer response = new StringBuffer();
//	     while ((inputLine = in.readLine()) != null) {
//	     	response.append(inputLine);
//	     }
//	     in.close();
//	     //print in String
//	     System.out.println(response.toString());
//	    
	}

}
