package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.DummyStep;

@DisplayName("Dummy Test Suite")
public class DummyTest extends TestBase {

    @Test
    @DisplayName("Dummy Test Example")
    @Description("La descripcion de un caso de prueba automatizado")
    public void Dummy_Test_Example() {

        DummyStep dummyStep = new DummyStep();
        dummyStep.validarWelcomeToJPetStore()
                 .clickEnEnterTheStore();
    }
}
