package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	@FindBy(linkText = "Laptops & Notebooks")
	private WebElement linkLaptopsAndNotebooks;

	@FindBy(linkText = "Show All Laptops & Notebooks")
	private WebElement linkAllLaptopsAndNotebooks;
	
	@FindBy(linkText = "Tablets")
	private WebElement linkTablets;

	@FindBy(linkText = "Phones & PDAs")
	private WebElement linkPhonesAndPDAs;
	
	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void clickLaptopsAndNotebooks() {
		linkLaptopsAndNotebooks.click();
	}
	public void clickLinkAllLaptopsAndNotebooks() {
		linkAllLaptopsAndNotebooks.click();
	}
	
	public void clickTablets() {
		linkTablets.click();
	}
	
	public void clickPhonesAndPDAs() {
		linkPhonesAndPDAs.click();
	}
	
	
}
