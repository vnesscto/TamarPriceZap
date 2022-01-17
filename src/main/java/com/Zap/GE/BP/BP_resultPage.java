package com.Zap.GE.BP;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Zap.GE.BP.Enums.eSortBy;
import com.Zap.GE.Pages.resultPage;

public class BP_resultPage {
	private WebDriver driver = null;
	private resultPage resultsPage;

	public BP_resultPage(WebDriver driver) {
		this.driver = driver;
		resultsPage = new resultPage(driver);
	}

	public boolean sortItems(eSortBy sortBy) {
		// tap sort by link
		BP_generalProcess.clickElement(resultsPage.getSortButton(sortBy));
		// validate page sort
		return validateSortItems(sortBy);
	}
	/** pulls out the small price of the item and convert it to integer **/
	private int getPriceAsNumber(WebElement priceElement) {
		String priceString = priceElement.getText();
		String[] priceStringHelper = priceString.split(" ");
		StringBuilder priceStringBuilder = new StringBuilder();

		try {
			for (int i = priceStringHelper.length - 1; i >= 0; i--) {
				priceStringBuilder = priceStringBuilder.append(priceStringHelper[i]);
			}
			// extract Digits from String
			StringBuilder builder = new StringBuilder();
			boolean isGetFirstPrice = false;
			for (int i = 0; i < priceStringBuilder.toString().length(); i++) {
				char c = priceStringBuilder.toString().charAt(i);
				if (Character.isDigit(c)) {
					builder.append(c);
					isGetFirstPrice = true;
				}
				if (!Character.isDigit(c) && isGetFirstPrice == true)
					return Integer.parseInt(builder.toString());
			}

			return Integer.parseInt(builder.toString());
		} catch (Exception e) {
			return -1;
			// TODO: write exception to log
		}
	}

	private boolean validateSortItems(eSortBy sortBy) {
		switch (sortBy) {
		case PRICE:
			int lastPrice = 0;
			int i = 0;
			do {
				List<WebElement> pageItemsPrices = getPageItemsPrice();
				for (WebElement itemPrice : pageItemsPrices) {
					int currentPrice = getPriceAsNumber(itemPrice);
					if (i == 0)
						lastPrice = currentPrice;
					if (lastPrice > currentPrice)
						return false;
					i++;
					lastPrice = currentPrice;
				}

				BP_generalProcess.clickElement(resultsPage.getNextButton());

			} while (resultsPage.getNextButton() != null);

			break;

		default:
			break;
		}
		return true;
	}

	/** gets all items prices from current page **/
	private List<WebElement> getPageItemsPrice() {
		List<WebElement> itemPrice = driver.findElements(By.xpath("//*[@class='pricesTxt']"));
		return itemPrice;
	}

}
