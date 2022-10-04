import Base.BaseTest;
import Model.BasePages.TestUtils;
import Model.MainPage;
import Model.LinnmonTablePage;
import Model.ShoppingBagPage;
import Model.UpplandSofaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeIkeaTest extends BaseTest {
  /**
   * Steps:
   * Navigate to: https://www.ikea.com/us/en
   * Using search bar at the top of the page - search for "sofa"
   * On the first page of search results, pick the 1st item in the list and add it to the cart
   * Using search bar at the top of the page - search for "table"
   * On the first page of search results, pick the 3rd item in the list and add it to the cart
   * Navigate to shopping cart page and validate that 2 items are added to the cart
   * Click on "Use a discount code" link, enter random string of 15 characters as discount code and click "Apply discount" button
   * Validate that "invalid coupon code" error message is displayed
   */
  @Test
  public void testValidateInvalidCouponMessage() throws InterruptedException {
    ShoppingBagPage newShoppingBagPage = new MainPage(getDriver())
        .submitCookies()
        .setSearchField(MainPage.class, "sofa")
        .clickSearchButton()
        .clickItemOnSearchResult(UpplandSofaPage.class, 1)
        .clickAddToBagButton(UpplandSofaPage.class)
        .closeDialogArea(UpplandSofaPage.class)
        .setSearchField(UpplandSofaPage.class, "table")
        .clickSearchButton()
        .clickItemOnSearchResult(LinnmonTablePage.class, 3)
        .clickAddToBagButton(LinnmonTablePage.class)
        .clickGoToCartLink();

    Assert.assertEquals(newShoppingBagPage.amountItemsInBasket(), 2);

    newShoppingBagPage
        .clickToDiscountCodeLink()
        .setDiscountCode(TestUtils.getRandomStr(15))
        .clickApplyButton();

    Assert.assertTrue(newShoppingBagPage.isMessageDiscountCodeErrorDisplay());
  }
}
