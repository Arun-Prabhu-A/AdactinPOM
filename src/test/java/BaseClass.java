import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static Actions act;
	static String fileLoc = "C:\\Users\\arunp\\eclipse-workspace\\Adactin\\src\\test\\resources\\AdactinHotelBook.xlsx";
	
	public static void webdriverConfig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void openURL(String url) {
		driver.get(url);
	}
	
	public static WebElement locateByClassName(String className) {
		return driver.findElement(By.className(className));
	}
	
	public static WebElement locateById(String Id) {
		return driver.findElement(By.id(Id));
	}
	
	public static WebElement locateByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public static void rightClick(WebElement element) {
		act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public static void keyPressRelease(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(key);
		robot.keyRelease(key);
	}
	
	//To read the data from Excel Sheet
	public static String excelSheetRead(String FileName, String SheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(FileName);
		FileInputStream fin = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet sheet1 = wb.getSheet(SheetName);
		Row row = sheet1.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		//System.out.println(cellType);
		if (cellType==1)
			return cell.getStringCellValue();
		else if (cellType==0) {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd/MM/YYYY");
				String formattedDate = sim.format(dateCellValue);
				return formattedDate;
			}
			else {
				double cellValue = cell.getNumericCellValue();
				long formattedNum = (long) cellValue;
				String stringFormatNum = Long.toString(formattedNum);
				return stringFormatNum;
			}
		}
		else {
			System.out.println("There is no value in the cell");
			return null;
		}
	}
	
	//To Select dropdown option by value
	public static void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	//To Select dropdown option by index
		public static void selectUsingIndex(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		
	//To Select dropdown option by index
		public static void selectUsingVisibleText(WebElement element, String index) {
			Select select = new Select(element);
			select.selectByVisibleText(index);
		}
		
	//To Click a WebElement with ID
		public static void clickElementUsingId(String id) {
			driver.findElement(By.id(id)).click();
		}
		
	//To Click a WebElement with xpath
		public static void clickElementUsingXpath(String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
		//To Click a WebElement with Class Name
		public static void clickElementUsingClassName(String className) {
			driver.findElement(By.className(className)).click();
		}
		
		public static void navigateForward() {
			driver.navigate().forward();
		}
		
		public static void navigateBackward() {
			driver.navigate().back();
		}
		
}
