package com.makemytrip;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BookingTickets {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("disable-popups");
		options.addArguments("start-maximized");
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Buses' and @class='headerIconTextAlignment chNavText darkGreyText']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Trichy");
		driver.findElement(By.xpath("//span[text()='Tiruchirapalli (Trichy), Tamil Nadu']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jun 06 2024']")).click();
		driver.findElement(By.xpath("//button[@id='search_button']")).click();
		List<String> l1 = new LinkedList<>();
		List<String> l2 = new LinkedList<>();
		List<String> l3 = new LinkedList<>();
		List<String> l4 = new LinkedList<>();
		List<WebElement> buses= driver.findElements(By.xpath("//p[contains(@class,'makeFlex hrtlCenter appendBottom')]"));
		List<WebElement> deptime = driver.findElements(By.xpath("//span[contains(@class,'latoBlack blackText')]"));
		List<WebElement> arrtime = driver.findElements(By.xpath("//span[contains(@class,'latoRegular')]"));
		List<WebElement> farerate = driver.findElements(By.xpath("//span[@id='price']"));
		for (int i = 0; i < buses.size(); i++) {
			String bus = buses.get(i).getText();
			l1.add(bus);
			String dep = deptime.get(i).getText();
			l2.add(dep);
			String arr = arrtime.get(i).getText();
			l3.add(arr);
			String fare = farerate.get(i).getText();
			l4.add(fare);
			System.out.println("Bus Name: "+bus+"Departure Time: "+dep+"Arrival Time: "+arr+"Fare rate: "+fare);
			}
		File f = new File("D:\\meeran\\new\\MakeMyTrip.xlsx");	
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet("Sheet1");
		for(int i=0; i<l1.size(); i++) {
			Row r = s.getRow(i);
			if (r == null) {
				r = s.createRow(i);
			}
			Cell c = r.createCell(0);
			c.setCellValue(l1.get(i));
		}
		for(int i=0; i<l2.size(); i++) {
			Row r = s.getRow(i);
			if (r == null) {
				r = s.createRow(i);
			}
			Cell c = r.createCell(1);
			c.setCellValue(l2.get(i));
		}
		for(int i=0; i<l3.size(); i++) {
			Row r = s.getRow(i);
			if (r == null) {
				r = s.createRow(i);
			}
			Cell c = r.createCell(2);
			c.setCellValue(l3.get(i));
		}
		for(int i=0; i<l4.size(); i++) {
			Row r = s.getRow(i);
			if (r == null) {
				r = s.createRow(i);
			}
			Cell c = r.createCell(3);
			c.setCellValue(l4.get(i));
		}
		FileOutputStream f1 = new FileOutputStream(f);
		w.write(f1);
		f1.close();
		driver.findElement(By.xpath("//p[text()='Sri Renu Travels']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//span[text()='₹1999'])[5]")).click();
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type here' and @type='text' and @id='fname']")).sendKeys("Meeran");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("26");
		WebElement male = driver.findElement(By.xpath("//span[starts-with(@class,'listingSprite male')]"));
		male.click();
		Boolean b = male.isDisplayed();
		System.out.println(b);
		driver.findElement(By.xpath("//input[@id='dt_state_gst_info']")).click();
		driver.findElement(By.xpath("//li[text()='Tamil Nadu']")).click();
		driver.findElement(By.xpath("//p[text()='Confirm and save billing details to your profile']")).click();
		driver.findElement(By.xpath("//input[@name='email id']")).sendKeys("meeranmohamed861@gmail.com");
		driver.findElement(By.xpath("//input[@name='Mobile Number']")).sendKeys("7358358710");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement up = driver.findElement(By.xpath("//span[text()='Continue']"));
		js.executeScript("arguments[0].scrollIntoView(false)",up);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	}
	


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
       


