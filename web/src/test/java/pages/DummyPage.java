package pages;

import org.openqa.selenium.By;

public class DummyPage {

    private final By enterTheStoreButton;
    private final By tituloWelcomeToJPetStore;

    public DummyPage() {
        enterTheStoreButton = By.xpath("//a[contains(text(),'Enter the Store')]");
        tituloWelcomeToJPetStore = By.xpath("//h2[contains(text(),'Welcome to JPetStore 6')]");
    }

    public By getEnterTheStoreButton() {
        return enterTheStoreButton;
    }

    public By getTituloWelcomeToJPetStore() {
        return tituloWelcomeToJPetStore;
    }
}
