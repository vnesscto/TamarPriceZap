package com.Zap.GE.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Zap.GE.BP.BP_generalProcess;
import com.Zap.GE.BP.BP_getCategory;
import com.Zap.GE.BP.BP_resultPage;
import com.Zap.GE.BP.Enums.eSortBy;
import com.Zap.GE.Pages.resultPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class Test1 {
	private static WebDriver driver;
	private static String subCategory;
	private static String category;
	private static BP_getCategory getCategory = null;
	private static BP_resultPage bpResultPage = null;

	@BeforeClass
	// @Parameters({"subCategory","category"})
	public void setUp() throws FileNotFoundException, IOException, ParseException {
		Object ob = new JSONParser().parse(new FileReader("src\\main\\java\\com\\Zap\\GE\\Test\\parmeters.json"));
		JSONObject js = (JSONObject) ob;
		subCategory = (String) js.get("subCategory");
		category = (String) js.get("category");
	}

	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.zap.co.il/");
		getCategory = new BP_getCategory(driver);
		bpResultPage = new BP_resultPage(driver);
	}

	@Test
	public void zapTest() {
		//for example subcategory="מחשבים ותוכנות",category="עכברים"
		getCategory.getSpesificCategory(subCategory, category);
		assertTrue(bpResultPage.sortItems(eSortBy.PRICE), "The page not sort correct");
	}
}
