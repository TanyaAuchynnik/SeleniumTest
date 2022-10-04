package Model;

import Model.BasePages.BaseHeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseHeaderPage {
  @FindBy(id = "onetrust-accept-btn-handler")
  private WebElement buttonAcceptCookies;

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public MainPage submitCookies() {
    getWait5().until(ExpectedConditions.visibilityOf(buttonAcceptCookies)).click();
    return this;
  }
}
