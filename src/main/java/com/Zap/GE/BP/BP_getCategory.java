package com.Zap.GE.BP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;

public class BP_getCategory {
	private WebDriver driver = null;

	public BP_getCategory(WebDriver driver) {
		this.driver = driver;
	}

	public void getMainCategory() {
		BP_generalProcess.clickElement(BP_generalProcess.findElement(By.xpath("//a[contains(@aria-label,'לחץ למעבר לכל הקטגוריות')]"),driver));
	}

	public void getSubCategory(String subCategory, String category) {
		BP_generalProcess.clickElement(BP_generalProcess.findElement(By.xpath("//*[normalize-space(text())='" + category+ "']/ancestor::div[@class='CategoriesList']//*[@aria-label='" + subCategory + "']"),driver));
	}

	public void getSpesificCategory(String subCategory, String category) {
			getMainCategory();
			getSubCategory(subCategory, category);
	}
}
