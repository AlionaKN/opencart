package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basetest.BaseTest;
import pages.LaptopsPage;
import pages.MainPage;
import pages.TabletsPage;
import utilities.FileReaderUtils;

public class TestProductAvailability extends BaseTest {

	private MainPage mainPage = new MainPage(driver);
	private TabletsPage tabletsPage = new TabletsPage(driver);
	private LaptopsPage laptopsPage = new LaptopsPage(driver);
	private String expectedText = "Availability: In Stock";
	private List<String> testdata;

	@Test
	public void testProductAvailabilityInLaptops() throws IOException {

		String rowLocator = "#content > div:nth-child(7) > div > div > div:nth-child(2) > div.caption > h4 > a";
		testdata = FileReaderUtils.getTestData("src/test/resources/TestData.txt");

		for (int i = 0; i < testdata.size(); i++) {
			if (testdata.get(i).contains("Laptops")) {
				mainPage.clickLaptopsAndNotebooks();
				mainPage.clickLinkAllLaptopsAndNotebooks();

				List<WebElement> rows = driver.findElements(By.cssSelector(rowLocator));

				for (int n = 0; n < rows.size(); n++) {

					rows.get(n).click();
					String actualtext = laptopsPage.getAvailabilityText();
					assertEquals("Availability status is not In Stock but ", expectedText, actualtext);

					mainPage.clickLaptopsAndNotebooks();
					mainPage.clickLinkAllLaptopsAndNotebooks();
					rows = driver.findElements(By.cssSelector(rowLocator));

				}
			}
		}

	}

	@Test
	public void testProductAvailabilityInTablets() throws IOException {

		String rowLocator = "#content > div > div > div > div:nth-child(2) > div.caption > h4 > a";
		testdata = FileReaderUtils.getTestData("src/test/resources/TestData.txt");

		for (int i = 0; i < testdata.size(); i++) {
			if (testdata.get(i).contains("Tablets")) {
				mainPage.clickTablets();
				List<WebElement> rows = driver.findElements(By.cssSelector(rowLocator));

				for (int n = 0; n < rows.size(); n++) {
					rows.get(n).click();
					String actualtext = tabletsPage.getAvailabilityText();
					assertEquals("Availability status is not In Stock ", expectedText, actualtext);
					rows = driver.findElements(By.cssSelector(rowLocator));
				}

			}
		}
	}

	@Test
	public void testProductAvailabilityInPhones() throws IOException {

		String rowLocator = "#content > div > div > div > div:nth-child(2) > div.caption > h4 > a";
		testdata = FileReaderUtils.getTestData("src/test/resources/TestData.txt");

		for (int i = 0; i < testdata.size(); i++) {
			if (testdata.get(i).contains("Phones")) {
				mainPage.clickPhonesAndPDAs();

				List<WebElement> rows = driver.findElements(By.cssSelector(rowLocator));
				for (int n = 0; n < rows.size(); n++) {

					rows.get(n).click();
					String actualtext = driver
							.findElement(
									By.cssSelector("#content > div > div.col-sm-4 > ul:nth-child(3) > li:nth-child(4)"))
							.getText();
					assertEquals("Availability status is not In Stock ", expectedText, actualtext);
					mainPage.clickPhonesAndPDAs();
					rows = driver.findElements(By.cssSelector(rowLocator));
				}
			}
		}
	}
}
