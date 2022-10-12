import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBooking extends BaseClass {
	
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCancelBooking;
	
	//@FindBy(className="reg_button")
	//WebElement btnConfirmCancel;
	
	public void cancelBookingDetails() {
		btnCancelBooking.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
	}
}
