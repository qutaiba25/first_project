package testing_for_Automationteststore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {

	WebDriver driver = new ChromeDriver();

	String THEURL = "https://automationteststore.com/";

	@BeforeTest

	public void mysetup() throws InterruptedException {

		driver.get(THEURL);

		driver.manage().window().maximize();
	}

	@Test

	public void SignUp() throws InterruptedException {

		// WebElement firstresult =
		// driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));

		Thread.sleep(3000);

		// firstresult.click();

		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		// driver.findElement(By.id("AccountFrm_firstname")).sendKeys("qutaiba");
		// driver.findElement(By.name("firstname")).sendKeys("Qutaiba");

		// elements
		WebElement firstnameinput = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastnameinput = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement EMailinput = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement Telephoneinput = driver.findElement(By.xpath("//input[@name='telephone']"));
		WebElement Faxinput = driver.findElement(By.xpath("//input[@name='fax']"));
		WebElement Companyinput = driver.findElement(By.xpath("//input[@name='company']"));
		WebElement Address1input = driver.findElement(By.xpath("//input[@name='address_1']"));
		WebElement Address2input = driver.findElement(By.xpath("//input[@name='address_2']"));
		WebElement Cityinput = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement Country = driver.findElement(By.name("country_id"));
		WebElement state = driver.findElement(By.name("zone_id"));
		WebElement postalcode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement loginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordconfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement PrivacyPolicy = driver.findElement(By.id("AccountFrm_agree"));

		// data
		String firstname = "Qutaiba";
		String lastname = "hesham";
		String EMail = firstname + lastname + "@gmail.com";
		String Telephone = "0799628777";
		String Fax = "8787";
		String Company = "zain";
		String Address1 = "tt55";
		String Address2 = "tf44";
		String City = "irbid";

		// actions
		firstnameinput.sendKeys(firstname);
		lastnameinput.sendKeys(lastname);
		EMailinput.sendKeys(EMail);
		Telephoneinput.sendKeys(Telephone);
		Faxinput.sendKeys(Fax);
		Companyinput.sendKeys(Company);
		Address1input.sendKeys(Address1);
		Address2input.sendKeys(Address2);
		postalcode.sendKeys("12345");
		Cityinput.sendKeys(City);
		Select myselectforcountry = new Select(Country);
		// الطريقه رقم1 في الاختيار myselectforcountry.selectByIndex(3);
		// الطريقة رقم2 في الاختيار myselectforcountry.selectByVisibleText("Jordan");
		// الطريقة رقم3 في الاختيار myselectforcountry.selectByValue("108");
		myselectforcountry.selectByValue("108");
		Select myselectforstate = new Select(state);
		myselectforstate.selectByVisibleText("Al Karak");
		loginName.sendKeys(firstname + lastname);
		passwordInput.sendKeys("qwer@1234");
		passwordconfirmInput.sendKeys("qwer@1234");
		PrivacyPolicy.click();

	}

}
