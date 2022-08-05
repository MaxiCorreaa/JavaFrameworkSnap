package steps;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DummyPage;
import tests.TestBase;

public class DummyStep extends TestBase {

    private final DummyPage dummyPage;

    public DummyStep() {
        dummyPage = new DummyPage();
    }

    public DummyStep validarWelcomeToJPetStore() {
        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(dummyPage.getTituloWelcomeToJPetStore()));
        Assertions.assertTrue(titulo.isDisplayed(), "El titulo no se encuentra en la web");
        return new DummyStep();
    }

    public void clickEnEnterTheStore() {
        WebElement enterTheStoreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(dummyPage.getEnterTheStoreButton()));
        Assertions.assertTrue(enterTheStoreButton.isDisplayed(), "El boton ClickEnEnterTheStore no se encontro en la web");
        enterTheStoreButton.click();
    }
}
