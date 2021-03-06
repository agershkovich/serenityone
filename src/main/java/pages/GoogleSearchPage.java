package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://google.com")
public class GoogleSearchPage extends PageObject {

  @FindBy(id = "lst-ib")
  private WebElement searchInputField;

  public GoogleSearchPage(WebDriver driver) {
    super(driver);
  }

  @WhenPageOpens
  public void waitUntilGoogleLogoAppears() {
    $("#hplogo").waitUntilVisible();
  }

  public GoogleResultsPage searchFor(String searchRequest) {
    element(searchInputField).clear();
    element(searchInputField).typeAndEnter(searchRequest);
    return new GoogleResultsPage(getDriver());
  }
}
