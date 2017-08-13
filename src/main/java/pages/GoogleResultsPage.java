package pages;

import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultsPage extends PageObject {

  @FindBy(xpath = "//h3")
  private List<WebElement> linkTitlesList;

  public GoogleResultsPage(WebDriver driver) {
    super(driver);
  }

  @WhenPageOpens
  public void waitForPage() {
    // wait for google sub menu: Web | Images | Videos | ...
    $("#hdtb-msb").waitUntilVisible();
  }

  public List<String> getResultsList() {
    List<String> resultList = new ArrayList<>();
    for (WebElement element : linkTitlesList) {
      resultList.add(element.getText());
    }
    return resultList;
  }
}
