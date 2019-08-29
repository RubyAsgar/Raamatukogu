package com.add.book;

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddVerifyBook {
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

  
@Before
public void setUp() throws Exception {
driver = new ChromeDriver();
baseUrl = "https://raamatukogu.herokuapp.com/";
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

 }


@Test
public void testAddVerifyBook() throws Exception {
driver.get(baseUrl + "/catalog");
driver.findElement(By.linkText("Create new book")).click();
driver.findElement(By.id("title")).clear();
System.out.println("Enter Book Name: ");
Scanner obj = new Scanner(System.in);
String uname = obj.nextLine();
driver.findElement(By.id("title")).sendKeys(uname);
new Select(driver.findElement(By.id("author"))).selectByVisibleText("Carroll, Lewis");
driver.findElement(By.id("summary")).clear();
System.out.println("Summary: ");
Scanner obj1 = new Scanner(System.in);
String summary = obj1.nextLine();
driver.findElement(By.id("summary")).sendKeys(summary);
driver.findElement(By.id("isbn")).clear();
System.out.println("ISBN: ");
Scanner obj2 = new Scanner(System.in);
String isbn = obj2.nextLine();
driver.findElement(By.id("isbn")).sendKeys(isbn);
driver.findElement(By.id("5b6714c93809970014e31c9a")).click();
driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
driver.findElement(By.linkText("All books")).click();

    try {
 assertTrue(isElementPresent(By.linkText(uname)));
if (isElementPresent(By.linkText(uname)))
{System.out.print("Test case passed. Book found");} 
 else
{System.out.print("Test case Failed. Book not found");}
    } catch (Error e) {
 verificationErrors.append(e.toString());

    }

  }


@After
 public void tearDown() throws Exception {
 driver.quit();
 String verificationErrorString = verificationErrors.toString();
if (!"".equals(verificationErrorString)) {
 fail(verificationErrorString);

    }

  }


 private boolean isElementPresent(By by) {
 try {
driver.findElement(by);
 return true;
} catch (NoSuchElementException e) {
 return false;

    }

  }


private boolean isAlertPresent() {
 try {
driver.switchTo().alert();
return true;
} catch (NoAlertPresentException e) {
 return false;

    }

  }


private String closeAlertAndGetItsText() {
try {
Alert alert = driver.switchTo().alert();
String alertText = alert.getText();
if (acceptNextAlert) {
 alert.accept();
} else {
 alert.dismiss();
}
 return alertText;
} finally {
 acceptNextAlert = true;

    }

  }

}
