package com.crm.qa.base;

import java.io.FileInputStream;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.crm.qa.util;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

//import com.sun.javafx.scene.control.Properties;

public class TestBase {

public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
public static WebDriver driver;
public static Properties prop;
public TestBase() {
try {
prop = new Properties();
FileInputStream ip = new FileInputStream("C:/Users/Ahmed2/eclipse-workspace/FreeCRMTest/src/main/java/com/crm"
+"/qa/config/config.properties");
prop.load(ip);
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace(); 
}
}
public static void initialiazation() throws InterruptedException {
	System.out.println("this went through test");
String browserName = prop.getProperty("browserName");
System.out.println("this went through test ");
if (browserName.equals("chrome")) {
	
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ahmed2\\eclipse-workspace\\chromedriver.exe");
driver = new ChromeDriver();
Thread.sleep(2000);
} else if (browserName.equals("FF")){
System.setProperty("webdriver.gecko.driver", "C:/Program Files/Java/geckodriver.exe");
driver = new FirefoxDriver();
}
driver. manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS); 
driver.get(prop.getProperty("url"));

e_driver = new EventFiringWebDriver(driver);
// Now create object of EventListerHandler to register it with EventFiringWebDriver
eventListener = new WebEventListener();
e_driver.register(eventListener);
driver = e_driver;

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

driver.get(prop.getProperty("url"));

}



}