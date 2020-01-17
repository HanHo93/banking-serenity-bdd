package Utils;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementActions extends UIInteractionSteps {

    public void click(By ele, String... eleName){
        $(ele).click();
        if(!eleName[0].isEmpty()){
            Log.info(String.format("Click %s", eleName[0]));
        }
    }

    public String getText(By ele, String... eleName){
        if(!eleName[0].isEmpty()){
            Log.info(String.format("Get text of %s", eleName[0]));
        }
        return $(ele).getText();
    }

    public static String getAttributeValue(WebElement ele, String att,  String... eleName){
        if(!eleName[0].isEmpty()){
            Log.info(String.format("Get attribute value of %s", eleName[0]));
        }
        return ele.getAttribute(att);
    }

    public void inputText(By ele, String value, String eleName){
        $(ele).clear();
        $(ele).type(value);
        String log = String.format("Type %s", value);
        if(!eleName.isEmpty()){
            log += String.format(" into %s", eleName);
        }
        Log.info(log);
    }

    public void inputDate(By ele, String value, String eleName){
        String[] date = value.split("/");
        $(ele).sendKeys(date[0]);
        $(ele).sendKeys(date[1]);
        $(ele).sendKeys(date[2]);
        String log = String.format("Type %s", value);
        if(!eleName.isEmpty()){
            log += String.format(" into %s", eleName);
        }
        Log.info(log);
    }

    public void switchToIframeAndClick(By eleIframe, By ele, String iframeName, String eleName) {
        Common.sleep(3);
        if (element(eleIframe).isCurrentlyVisible()) {
            getDriver().switchTo().frame((WebElement) find(eleIframe));
            $(ele).click();
            getDriver().switchTo().parentFrame();
            Log.info("Switch to " + iframeName +" and click on "+ eleName);
        }
    }

    public void selectFromDropDown(By ele, String visibleText, String eleName){
        $(ele).selectByValue(visibleText);
        String log = String.format("Select %s", visibleText);
        if(!eleName.isEmpty()){
            log += String.format(" from %s", eleName);
        }
        Log.info(log);
    }
}
