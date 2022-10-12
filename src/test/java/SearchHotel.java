import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="location")
	private WebElement dndLocation;
	public WebElement getDndLocation() {
		return dndLocation;
	}
	
	@CacheLookup
	@FindBy(id="hotels")
	private WebElement dndHotels;
	public WebElement getDndHotels() {
		return dndHotels;
	}
	
	@CacheLookup
	@FindBy(id="room_type")
	private WebElement dndRoomType;
	public WebElement getDndRoomType() {
		return dndRoomType;
	}
	
	@CacheLookup
	@FindBy(id="room_nos")
	private WebElement dndRoomNos;
	public WebElement getDndRoomNos() {
		return dndRoomNos;
	}
	
	@CacheLookup
	@FindBy(id="datepick_in")
	private WebElement txtCheckIn;
	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}
	
	@CacheLookup
	@FindBy(id="datepick_out")
	private WebElement txtCheckOut;
	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}
	
	@CacheLookup
	@FindBy(id="adult_room")
	private WebElement dndAdultNo;
	public WebElement getDndAdultNo() {
		return dndAdultNo;
	}
	
	@CacheLookup
	@FindBy(id="child_room")
	private WebElement dndChildNo;
	public WebElement getDndChildNo() {
		return dndChildNo;
	}
	
	@CacheLookup
	@FindBy(id="Submit")
	private WebElement btnSubmit;
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
	public void searchHotel() throws IOException {
		WebElement dndLocation = getDndLocation();
		selectUsingValue(dndLocation, excelSheetRead(fileLoc, "Details", 1, 3));
		
		WebElement dndHotels = getDndHotels();
		selectUsingValue(dndHotels, excelSheetRead(fileLoc, "Details", 1, 4));
		
		WebElement dndRoomType = getDndRoomType();
		selectUsingValue(dndRoomType, excelSheetRead(fileLoc, "Details", 1, 5));
		
		WebElement dndRoomNos = getDndRoomNos();
		selectUsingValue(dndRoomNos, excelSheetRead(fileLoc, "Details", 1, 6));
		
		WebElement txtCheckIn = getTxtCheckIn();
		txtCheckIn.clear();
		txtCheckIn.sendKeys(excelSheetRead(fileLoc, "Details", 1, 7));
		
		WebElement txtCheckOut = getTxtCheckOut();
		txtCheckOut.clear();
		txtCheckOut.sendKeys(excelSheetRead(fileLoc, "Details", 1, 8));
		
		WebElement dndAdultNo= getDndAdultNo();
		selectUsingValue(dndAdultNo, excelSheetRead(fileLoc, "Details", 1, 9));
		
		WebElement dndChildNo= getDndChildNo();
		selectUsingValue(dndChildNo, excelSheetRead(fileLoc, "Details", 1, 10));
		
		getBtnSubmit().click();
	}
}
