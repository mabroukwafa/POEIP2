package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Utils {
    public static final int MAX = 26;
    public static String generateRandomString(int length){
        {
            char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u',
                    'v', 'w', 'x', 'y', 'z' };

            String res = "";
            for (int i = 0; i < length; i++)
                res += alphabet[(int) (Math.random() * 100 % MAX)];

            return res;
        }
    }
    public static String generateRandomEmail(int lengthBeforeAt, int lengthAfterAt){
        return generateRandomString(lengthBeforeAt) + "@" + generateRandomString(lengthAfterAt) + ".com";
    }

    public static ExpectedCondition<Boolean> frameToBeAvailableAndSwitchToIt(final WebElement var0) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver var1) {
                try {
                    if (var0.isDisplayed()) {
                        var1.switchTo().frame(var0);
                        return true;
                    }
                } catch (NoSuchFrameException var3) {
                    return false;
                } catch (NoSuchElementException var4) {
                    return false;
                } catch (StaleElementReferenceException var5) {
                    return false;
                }
                return false;
            }

            public String toString() {
                return "frame to be available: " + var0;
            }
        };
    }
}
