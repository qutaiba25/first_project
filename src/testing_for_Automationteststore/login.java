package testing_for_Automationteststore;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {

	WebDriver driver = new ChromeDriver();
	String username;
	String passwordlogin = "qwer@1234";

	String THEURL = "https://automationteststore.com/";

	Random rand = new Random();

	@BeforeTest

	public void mysetup() throws InterruptedException {

		driver.get(THEURL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1, enabled = true)

	public void SignUp() throws InterruptedException {

		String confirmationMessage = "Your Account Has Been Created!";

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

		int randomNumberForTheEMail = rand.nextInt(19800);
		// rand.nextInt(9800);
		String[] firstNames = { "anas", "ali", "kaled", "mamoun", "qutiba" };
		int randomNameIndexForFirstNames = rand.nextInt(firstNames.length);
		String randomFirstName = firstNames[randomNameIndexForFirstNames];

		String lastNames[] = { "hesham", "ameen", "mahmoud", "qusai", "ahmad" };
		int randomNameIndexForLastNames = rand.nextInt(lastNames.length);
		String randomnLastName = lastNames[randomNameIndexForLastNames];

		String EMail = randomFirstName + randomnLastName + randomNumberForTheEMail + "@gmail.com";
		String Telephone = "0799628777";
		String Fax = "8787";
		String Company = "Zain";
		String Address1 = "tt56";
		String Address2 = "tf45";
		String City = "Irbid";
		username = randomFirstName + "_" + randomnLastName + randomNumberForTheEMail;

		Thread.sleep(3000);

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
		username = randomFirstName + "_" + randomnLastName + randomNumberForTheEMail;
		loginName.sendKeys(username);
		passwordInput.sendKeys(passwordlogin);
		passwordconfirmInput.sendKeys(passwordlogin);
		PrivacyPolicy.click();
		Thread.sleep(3000);
		ContinueButton.click();
		Thread.sleep(1000);
		boolean ActualResult = driver.getPageSource().contains(confirmationMessage);
		Assert.assertEquals(ActualResult, true, "this is to check if the account is created");

	}

	@Test(priority = 2, enabled = true)

	public void logoff() throws InterruptedException {

		String logoutconfirmationMessage = "Account Logout";

		Thread.sleep(2000);

		WebElement Logoff = driver.findElement(By.linkText("Logoff"));

		Logoff.click();

		boolean actualResults = driver.getPageSource().contains(logoutconfirmationMessage);
		boolean expectedResult = true;
		Assert.assertEquals(actualResults, expectedResult, "this is to check that the user has been logged out");

	}

	@Test(priority = 3, enabled = true)

	public void Login() {

		String loginConfirmationMessage = "Welcome back" ;

		WebElement LoginorRegister = driver.findElement(By.partialLinkText("Login or re"));
		LoginorRegister.click();

		WebElement Login = driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));

		Login.sendKeys(username);
		password.sendKeys(passwordlogin);

		driver.findElement(By.xpath("//button[@title='Login']")).click();

		boolean ACtualREsuletlogin = driver.getPageSource().contains(loginConfirmationMessage);
		boolean EXpectedREsultlogin = true;
		Assert.assertEquals(ACtualREsuletlogin, EXpectedREsultlogin,
				"this is to check that the user has been logged in");

	}

	@Test(priority = 4, invocationCount = 5, enabled = false)

	public void addItemToTheCart() throws InterruptedException {
		driver.navigate().to("https://automationteststore.com/");
		String[] sectionsNames = { "featured", "latest", "bestseller", "special" };
		int randomSectionsIndex = rand.nextInt(sectionsNames.length);
		WebElement TheFeatured = driver.findElement(By.id(sectionsNames[randomSectionsIndex]));
//		WebElement Container = driver.findElement(By.cssSelector(".col-md-12.col-xs-12.mt20"));
//      هذه طريقه للدخول على العناصر لاكنها لا تفضل لانها ليست دقيقه ويمكن ان تضغط على مكان لا يدخلك للعصنر  
//      List<WebElement> AllItems =TheFeatured.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12"));
		List<WebElement> AllItems = TheFeatured.findElements(By.className("prdocutname"));
		int randomProduct = rand.nextInt(AllItems.size());
		AllItems.get(randomProduct).click();
		Thread.sleep(2000);

		String productPage = driver.findElement(By.className("productpagecart")).getText();
		if (productPage.equals("Out of Stock")) {
			driver.navigate().back();
			System.out.println("sorry the item is not available");
		} else {
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("product_id=116")) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[1]/div")).click();

			}
			{

			}
			driver.findElement(By.partialLinkText("Add to Cart")).click();

		}

	}

}
