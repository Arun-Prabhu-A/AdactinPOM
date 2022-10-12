import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Runner extends BaseClass{

	public static void main(String[] args) throws InterruptedException, IOException {
		webdriverConfig();
		openURL("http://adactinhotelapp.com/");
		maximizeWindow();
		
		Login log = new Login();
		log.loginDetails();
		
		SearchHotel search = new SearchHotel();
		search.searchHotel();
		
		SelectHotel selecthotel = new SelectHotel();
		selecthotel.selectHotelDetails();
		
		BookHotel book = new BookHotel();
		book.bookHotelDetails();
		
		CancelBooking cancel = new CancelBooking();
		cancel.cancelBookingDetails();
	}

}
