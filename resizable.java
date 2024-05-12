package com.resizable;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class resizable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thasleem\\Downloads\\chromedriverwin\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> i1=wh.iterator();
		String mainwindow=driver.getWindowHandle();
		System.out.print(mainwindow);
		System.out.print(wh);

		while(i1.hasNext())
		{
			String childwindow=i1.next(); 
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='load_box']//a[@class='fancybox'][normalize-space()='ENTER TO THE TESTING WEBSITE']")).click();
				driver.findElement(By.xpath("//h2[normalize-space()='Resizable']")).click();
				Set<String> wh1=driver.getWindowHandles();
				Iterator<String> i2=wh1.iterator();
				while(i2.hasNext())
				{
					String childwindow1=i2.next(); 
					if(!mainwindow.equalsIgnoreCase(childwindow1) && !childwindow.equalsIgnoreCase(childwindow1))
					{
						driver.switchTo().window(childwindow1);
						Thread.sleep(3000);
						driver.switchTo().frame(0);
						WebElement e=driver.findElement(By.xpath("(//*[@id='resizable']/div[3])[1]"));
						Actions a=new Actions(driver);
						a.clickAndHold(e).moveByOffset(100, 100).build().perform();
						a.release(e).build().perform();
						Thread.sleep(3000);
						WebElement e1=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']"));
						Actions b =new Actions(driver);
						b.clickAndHold(e1).moveByOffset(50, 50).build().perform();
						b.release(e1).build().perform();
						Thread.sleep(3000);
						WebElement e2=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
						Actions c=new Actions(driver);
						c.clickAndHold(e2).moveByOffset(50, 50).build().perform();
						c.release(e2).build().perform();
						Thread.sleep(3000);
						driver.switchTo().defaultContent();

						driver.findElement(By.xpath("//a[normalize-space()='Animate']")).click();
						driver.switchTo().frame(1);
						WebElement e3=driver.findElement(By.xpath("//div//div[1][@class='ui-resizable-handle ui-resizable-e']"));
						Actions d =new Actions(driver);
						d.clickAndHold(e3).moveByOffset(50, 50).build().perform();
						d.release(e3).build().perform();
						driver.switchTo().defaultContent();
						Thread.sleep(3000);
						WebElement e4=driver.findElement(By.xpath("(//*[@id=\"resizable\"]/div[2])"));
						Actions f=new Actions(driver);
						f.clickAndHold(e4).moveByOffset(50, 50).build().perform();
						f.release(e4).build().perform();
						WebElement e5=driver.findElement(By.xpath("(//div//div[3][@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se'])"));
						Actions g=new Actions(driver);
						g.clickAndHold(e5).moveByOffset(50, 50).build().perform();
						g.release(e5).build().perform();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[normalize-space()='Constrain resize area']")).click();
						driver.switchTo().frame(2);
						WebElement e6=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
						Actions h =new Actions(driver);
						Thread.sleep(3000);
						h.clickAndHold(e6).moveByOffset(200, 200).build().perform();
						h.release(e6).build().perform();
						driver.switchTo().defaultContent();
						WebElement e7=driver.findElement(By.xpath("//body/div[@id='container']/div[@id='resizable']/div[1]"));
						Actions i =new Actions(driver);
						Thread.sleep(3000);
						i.clickAndHold(e7).moveByOffset(100, 100).build().perform();
						i.release(e7).build().perform();



					}

				}
			}
		}
	}
}
