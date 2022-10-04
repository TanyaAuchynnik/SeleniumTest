package Model;

import Model.BasePages.BaseHeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SearchProductsPage extends BaseHeaderPage {
  public SearchProductsPage(WebDriver driver) {
    super(driver);
  }

  public <T extends BaseHeaderPage> T clickItemOnSearchResult(Class<T> type, int itemIndex) {
    getDriver().findElement(By.xpath(String.format("//div[@id='search-results']/div[%s]", itemIndex))).click();
    Constructor<T> cons = null;
    try {
      cons = type.getConstructor(WebDriver.class);
      return cons.newInstance(getDriver());
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
