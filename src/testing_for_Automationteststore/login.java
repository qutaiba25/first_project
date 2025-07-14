package testing_for_Automationteststore;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {

	WebDriver driver = new ChromeDriver();
	String username;
	String passwordlogin = "qwer@1234";

	String THEURL = "https://automationteststore.com/";

	@BeforeTest

	public void mysetup() throws InterruptedException {

		driver.get(THEURL);

		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = true)

	public void SignUp() throws InterruptedException {

		Random rand = new Random();

		// WebElement firstresult =
		// driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));

		Thread.sleep(3000);

		// firstresult.click();

		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		// driver.findElement(By.id("AccountFrm_firstname")).sendKeys("qutaiba");
		// driver.findElement(By.name("firstname")).sendKeys("Qutaiba");

		// elements
		WebElement firstNameinput = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastNameinput = driver.findElement(By.xpath("//input[@name='lastname']"));
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
		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));

		// data
		System.out.println(driver.getCurrentUrl());
		rand.nextInt(9800);
		String[] firstNames = { "anas", "ali", "kaled", "mamoun", "qutiba" };
		int randomNameIndexForFirstNames = rand.nextInt(firstNames.length);
		String randomFirstName = firstNames[randomNameIndexForFirstNames];

		String lastNames[] = { "hesham", "ameen", "mahmoud", "qusai", "ahmad" };
		int randomNameIndexForLastNames = rand.nextInt(lastNames.length);
		String randomnLastName = lastNames[randomNameIndexForLastNames];

		String EMail = randomFirstName + randomnLastName + "@gmail.com";
		String Telephone = "0799628777";
		String Fax = "8787";
		String Company = "Zain";
		String Address1 = "tt56";
		String Address2 = "tf45";
		String City = "Irbid";

		// Thread.sleep(3000);

		// actions
		firstNameinput.sendKeys(randomFirstName);
		lastNameinput.sendKeys(randomnLastName);
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
		username = randomFirstName + randomnLastName;
		loginName.sendKeys(username);
		passwordInput.sendKeys(passwordlogin);
		passwordconfirmInput.sendKeys(passwordlogin);
		PrivacyPolicy.click();
		Thread.sleep(3000);
		ContinueButton.click();

	}

	@Test(priority = 2, enabled = true)

	public void logout() throws InterruptedException {

		Thread.sleep(2000);

		WebElement Logout = driver.findElement(By.linkText("Logoff"));

		Logout.click();

	}

	@Test(priority = 3, enabled = true)

	public void Login() {

		WebElement LoginorRegister = driver.findElement(By.partialLinkText("Login or re"));
		LoginorRegister.click();

		WebElement Login = driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));

		Login.sendKeys(username);
		password.sendKeys(passwordlogin);

		driver.findElement(By.xpath("//button[@title='Login']")).click();

	}

}
