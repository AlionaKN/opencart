package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabletsPage extends AbstractPage{

	// text
	@FindBy(css = "#content > div > div.col-sm-4 > ul:nth-child(3) > li:nth-child(3)")
	private WebElement availabilityText;
	
	
	public TabletsPage(WebDriver driver) {
		super(driver);
	}

	public String getAvailabilityText() {
		return availabilityText.getText();
	}
}
