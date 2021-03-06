package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageFile {
	private WebDriver driver;
	public By firstNameLocator = By.name("firstname");
	public By lastNameLocator = By.name("lastname");
	public By phoneLocator = By.name("phone");
	public By emailLocator = By.name("email");
	public By passwordLocator = By.name("password");
	public By confirmPasswordLocator = By.name("confirmpassword");
	public By signUpLocator = By.xpath("//button[@type='submit']");

	public RegisterPageFile(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void clickSubmit() {
		findElement(signUpLocator).click();
	}

	public void sendKeysToLocator(String value, By locator) {
		findElement(locator).clear();
		findElement(locator).sendKeys(value);
	}

	public boolean isEmptyField(By locator) {
		boolean isEmptyField = false;
		String message = findElement(locator).getAttribute("validationMessage");
		if (message.equals("Please fill out this field.")) {
			isEmptyField = true;
		} else {
			isEmptyField = false;
		}
		return isEmptyField;
	}

	public boolean errorMessageFor(String errorType) {
		boolean errorExists = false;
		if (errorType.trim().toLowerCase().equals("first name")) {
			String message = findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
			if (message.equals("The Email field must contain a valid first name.")) {
				errorExists = true;
			}
			else{
				errorExists = false;
			}
		}

		if (errorType.trim().toLowerCase().equals("last name")) {
			String message = findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
			if (message.equals("The Email field must contain a valid last name.")) {
				errorExists = true;
			}
			else{
				errorExists = false;
			}
		}

		if (errorType.trim().toLowerCase().equals("email")) {
			String message = findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
			if (message.equals("The Email field must contain a valid email address.")) {
				errorExists = true;
			}
			else{
				errorExists = false;
			}
		}

		if (errorType.trim().toLowerCase().equals("phone")) {
			String message = findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
			if (message.equals("The Email field must contain a valid phone number.")) {
				errorExists = true;
			}
			else{
				errorExists = false;
			}
		}

		if (errorType.trim().toLowerCase().equals("password")) {
			String message = findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
			if (message.equals("The Password field must be at least 8 characters in length and "
					+ "at least a capital letter and a small letter.")) {
				errorExists = true;
			}
			else{
				errorExists = false;
			}
		}

		return errorExists;
	}
	
	public boolean successMessage(String firstname, String lastname){
		boolean success = false;
		
		String message = findElement(By.xpath("//div[@class='col-md-8']/h3")).getText();
		if(message.equals("Hi, " + firstname + " " + lastname))
		{
			success = true;
		}
		else{
			success = false;
		}
		
		return success;
	}
}
