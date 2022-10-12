import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookHotel extends BaseClass {

	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@CacheLookup
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@CacheLookup
	@FindBy(id="address")
	private WebElement address;
	
	@CacheLookup
	@FindBy(id="cc_num")
	private WebElement ccNum;
	
	@CacheLookup
	@FindBy(id="cc_type")
	private WebElement ccType;
	
	@CacheLookup
	@FindBy(id="cc_exp_month")
	private WebElement expiryMonth;
	
	@CacheLookup
	@FindBy(id="cc_exp_year")
	private WebElement expiryYear;
	
	@CacheLookup
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	
	@CacheLookup
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
	public void bookHotelDetails() throws InterruptedException, IOException {
		firstName.sendKeys(excelSheetRead(fileLoc, "Details", 1, 11));
		lastName.sendKeys(excelSheetRead(fileLoc, "Details", 1, 12));
		address.sendKeys(excelSheetRead(fileLoc, "Details", 1, 13));
		ccNum.sendKeys(excelSheetRead(fileLoc, "Details", 1, 14));
		selectUsingVisibleText(ccType, excelSheetRead(fileLoc, "Details", 1, 15));
		selectUsingVisibleText(expiryMonth, excelSheetRead(fileLoc, "Details", 1, 16));
		selectUsingVisibleText(expiryYear, excelSheetRead(fileLoc, "Details", 1, 17));
		cvv.sendKeys(excelSheetRead(fileLoc, "Details", 1, 17));
		btnBookNow.click();
		Thread.sleep(6000);
		clickElementUsingId("my_itinerary");
	}
}
