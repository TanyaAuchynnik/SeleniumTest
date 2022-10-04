package Model;

import Model.BasePages.BaseHeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingBagPage extends BaseHeaderPage {
  @FindBy(className = "product_informationContainer__W9LP8")
  private List<WebElement> itemsInShoppingBag;

  @FindBy(xpath = "//div[contains(text(),'Have a discount code?')]")
  private WebElement linkDiscountCode;

  @FindBy(id = "discountCode")
  private WebElement inputDiscountCode;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement buttonApply;

  @FindBy(xpath = "//span[@id='discount-code__error']/span[2]")
  private WebElement messageDiscountCodeError;

  public ShoppingBagPage(WebDriver driver) {
    super(driver);
  }

  public int amountItemsInBasket() {
    return itemsInShoppingBag.size();
  }

  public ShoppingBagPage clickToDiscountCodeLink() {
    linkDiscountCode.click();
    return this;
  }

  public ShoppingBagPage setDiscountCode(String code) {
    inputDiscountCode.sendKeys(code);
    return this;
  }

  public ShoppingBagPage clickApplyButton() {
    buttonApply.click();
    return this;
  }

  public boolean isMessageDiscountCodeErrorDisplay() {
    return messageDiscountCodeError.isDisplayed();
  }
}
