import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass{
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="radiobutton_0")
	private WebElement btnRadioButton;
	
	@CacheLookup
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	public void selectHotelDetails() {
		btnRadioButton.click();
		btnContinue.click();
	}
}
