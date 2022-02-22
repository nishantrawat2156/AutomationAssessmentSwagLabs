package page_functions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_repositories.CartPage;
import util.BasicActions;

public class CartImpl extends BasicActions {

    public CartImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Verify name and price of selected product")
    public void verifyProduct() {
        sleep(2);
        Assert.assertTrue(dataMatcher(CartPage.ProdTextName, CartPage.Cart_Product_Name));
        Assert.assertTrue(dataMatcher(CartPage.ProdTextPrice, CartPage.Cart_Product_Price));
    }

    @Step("Proceed to checkout")
    public CheckoutInfoImpl clickCheckout() {
        sleep(1);
        click(CartPage.Checkout_Button);
        return new CheckoutInfoImpl(bot);
    }

    /**
     * Verifying product removal here
     */
    @Step("Check whether the cart is empty")
    public void checkProductRemoval() {
        sleep(1);
        verifyProductRemoval(By.id(CartPage.ProdTextName));
        System.out.println("Product removed successfully!");
    }
}
