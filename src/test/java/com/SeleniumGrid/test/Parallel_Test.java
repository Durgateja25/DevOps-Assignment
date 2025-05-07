package com.SeleniumGrid.test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel_Test {
	
	public WebDriver driver;
	@Parameters({"bname"})
  @Test
  
  public void crossBrowser_Test(String bname) throws MalformedURLException, URISyntaxException, InterruptedException 
  {
		System.out.println("Remote driver connectivity is started!");
	  if(bname.equals("Chrome"))
	  {
		  ChromeOptions options = new ChromeOptions();
		  
		  driver = new RemoteWebDriver(new URI("http://localhost:4444").toURL(),options);
		  System.out.println("Session created on Chrome!");
	  }
	  else if(bname.equals("Firefox"))
	  {
		  FirefoxOptions options = new FirefoxOptions();
		  
		  driver = new RemoteWebDriver(new URI("http://localhost:4444").toURL(),options);
		  System.out.println("Session created on Firefox!");
	  }
	  else if(bname.equals("Edge"))
	  {
		  EdgeOptions options = new EdgeOptions();
		  
		  driver = new RemoteWebDriver(new URI("http://localhost:4444").toURL(),options);
		  System.out.println("Session created on Edge!");
	  }
	  
	  
	  //open application
	  System.out.println("Remote driver connectivity is completed!");
	  Thread.sleep(10000);
	  driver.get("https://www.amazon.in");
	  Thread.sleep(6000);
	  System.out.println("Title is :"+driver.getTitle());
	  
	  driver.quit();
  }
}
