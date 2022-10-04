package Model.BasePages;

import Model.ShoppingBagPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BaseProductPage extends BaseHeaderPage{
  @FindBy(xpath = "//span[contains(text(),'Add to bag')]")
  private WebElement buttonAddToBag;

  @FindBy(xpath = "//div/button[@aria-label='Close']")
  private WebElement dialogAreaClose;

  @FindBy(xpath = "//a[@data-testid='go-to-cart']")
  private WebElement linkGoToCart;

  public BaseProductPage(WebDriver driver) {
    super(driver);
  }

  public <T extends BaseHeaderPage> T clickAddToBagButton(Class<T> type) {
    getActions().moveToElement(buttonAddToBag).click().perform();
    Constructor<T> cons = null;
    try {
      cons = type.getConstructor(WebDriver.class);
      return cons.newInstance(getDriver());
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public <T extends BaseHeaderPage> T closeDialogArea(Class<T> type) {
    dialogAreaClose.click();
    Constructor<T> cons = null;
    try {
      cons = type.getConstructor(WebDriver.class);
      return cons.newInstance(getDriver());
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public ShoppingBagPage clickGoToCartLink() {
    linkGoToCart.click();
    return new ShoppingBagPage(getDriver());
  }
}
