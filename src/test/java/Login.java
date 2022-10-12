import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass{
	
		public Login() {
			PageFactory.initElements(driver, this);
		}
		
		@CacheLookup
		@FindBy(id="username")
		private WebElement txtUser;
		
		@CacheLookup
		@FindBy(id="password")
		private WebElement txtPass;
		
		@CacheLookup
		@FindBy(id="login")
		private WebElement btnLogin;
		
		public WebElement getTxtUser() {
			return txtUser;
		}
		
		public WebElement getTxtPass() {
			return txtPass;
		}
		
		public WebElement getBtnLogin() {
			return btnLogin;
		}
		
		public void loginDetails() throws IOException {
			getTxtUser().sendKeys(excelSheetRead(fileLoc, "Details", 1, 1));
			getTxtPass().sendKeys(excelSheetRead(fileLoc, "Details", 1, 2));
			getBtnLogin().click();
		}
}
