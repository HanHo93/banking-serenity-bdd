package Utils;

import global.Const;
import net.serenitybdd.screenplay.actions.ScrollToBy;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Common{
    public static void sleep(int seconds){
        try{
            Thread.sleep(Const.TIMEOUT_IN_SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ScrollToTarget to(Target target) {
        return new ScrollToTarget(target);
    }

    public static ScrollToWebElement to(WebElement element) {
        return new ScrollToWebElement(element);
    }

    public static ScrollToBy to(By... locators) {
        return new ScrollToBy(locators);
    }

}
