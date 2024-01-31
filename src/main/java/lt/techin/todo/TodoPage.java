package lt.techin.todo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodoPage extends BasePage {


    public TodoPage(WebDriver driver) {
        super(driver);
    }

    //   1.
    @FindBy(css = "#container > input")
    WebElement inputTodoText;

    public void addNewElement(String newItemText) {
        inputTodoText.sendKeys(newItemText);
        inputTodoText.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//div[@id='container']/ul/li[last()]")
    WebElement lastItem;

    public String getLastElementText() {
        return lastItem.getText();
    }

    @FindBy(css = "ul > li")
    List<WebElement> elements;

    public int isNewElementOnTheList() {
        return elements.size();
    }


    //2.
    public void markLastElement() {
        lastItem.click();
    }

    public boolean elementsState() {
        for (WebElement element : elements) {
            if (!element.isEnabled()) {
                return false;
            }
        }
        return true;
    }


    //3.
    @FindBy(css = ".completed .fa-trash")
    WebElement bin;

    public void goToBin() {
        Actions goTo = new Actions(driver);
        goTo.moveToElement(bin).perform();
        bin.click();
    }

    public boolean isLastElementDisplayed() {
        return lastItem.isDisplayed();
    }
}

