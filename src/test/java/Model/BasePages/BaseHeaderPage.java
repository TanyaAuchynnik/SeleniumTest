package Model.BasePages;

import Model.SearchProductsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BaseHeaderPage extends BasePage{
  @FindBy(name = "q")
  private WebElement inputSearch;

  @FindBy(id = "search-box__searchbutton")
  private WebElement buttonSearch;

  public BaseHeaderPage(WebDriver driver) {
    super(driver);
  }

  public <T extends BasePage> T setSearchField(Class<T> type, String text) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    Thread.sleep(1000);
    js.executeScript("window.scrollTo(0, 0)", "");
    inputSearch.clear();
    inputSearch.sendKeys(text);
    Constructor<T> cons = null;
    try {
      cons = type.getConstructor(WebDriver.class);
      return cons.newInstance(getDriver());
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public SearchProductsPage clickSearchButton() {
    buttonSearch.click();
    return new SearchProductsPage(getDriver());
  }
}
