package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Classe de test qui exécute les scénarios Cucumber.
 * Elle utilise les annotations CucumberOptions pour configurer l'exécution des tests.
 * Les options incluent le chemin vers les fichiers de fonctionnalités, le code source des étapes,
 * et les plugins pour générer des rapports.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue={"steps","hooks"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)

public class RunnerTest {
}
