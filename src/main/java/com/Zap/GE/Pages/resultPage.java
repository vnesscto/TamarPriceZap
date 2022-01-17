package com.Zap.GE.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Zap.GE.BP.BP_generalProcess;
import com.Zap.GE.BP.Enums.eSortBy;

public class resultPage {
	private WebDriver driver;

	public resultPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNextButton() {
		return BP_generalProcess.findElement(By.xpath("//*[@class='ForwordBtn']"), driver);
	}

	public WebElement getSortButton(eSortBy sortBy) {
		return BP_generalProcess.findElement(
				By.xpath("//*[@class='SortByList']/*[@aria-label='מיין לפי " + sortBy.val() + "']"), driver);
	}
}