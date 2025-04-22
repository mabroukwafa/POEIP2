package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Classe utilitaire pour stocker des méthodes personnalisées communes utilisées dans le projet.
 */
public class Utils {
    public static final int MAX = 26;

    /**
     * Génère une chaîne de caractères aléatoire de la longueur spécifiée.
     *
     * @param length La longueur de la chaîne à générer
     * @return Une chaîne de caractères aléatoire
     */
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

    /**
     * Génère une adresse e-mail aléatoire avec la longueur spécifiée avant et après le symbole '@'.
     *
     * @param lengthBeforeAt La longueur de la partie avant le symbole '@'
     * @param lengthAfterAt  La longueur de la partie après le symbole '@'
     * @return Une adresse e-mail aléatoire
     */
    public static String generateRandomEmail(int lengthBeforeAt, int lengthAfterAt){
        return generateRandomString(lengthBeforeAt) + "@" + generateRandomString(lengthAfterAt) + ".com";
    }

    /**
     * Attente explicite pour vérifier si un élément est affiché et basculer vers le cadre correspondant.
     *
     * @param var0 L'élément WebElement à vérifier
     * @return Une condition d'attente explicite
     */
    public static ExpectedCondition<Boolean> frameToBeAvailableAndSwitchToIt(final WebElement var0) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver var1) {
                try {
                    if (var0.isDisplayed()) {
                        var1.switchTo().frame(var0);
                        return true;
                    }
                } catch (NoSuchFrameException | NoSuchElementException | StaleElementReferenceException var3) {
                    return false;
                }
                return false;
            }

            /**
             * Méthode pour obtenir une représentation sous forme de chaîne de la condition.
             * @return Une chaîne décrivant la condition
             */
            public String toString() {
                return "frame to be available: " + var0;
            }
        };
    }
}
