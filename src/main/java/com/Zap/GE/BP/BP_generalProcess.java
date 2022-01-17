package com.Zap.GE.BP;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BP_generalProcess {
	private static WebDriver driver = null;

	public static void clickElement(WebElement element) {
		assertTrue(element != null, "The Element " + element.toString() + "  Not Found");
		element.click();
	}
	
	public static WebElement findElement(By by, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return element;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	public static List<WebElement> findElements(By by, WebDriver driver) {
		try {
			return driver.findElements(by);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
}