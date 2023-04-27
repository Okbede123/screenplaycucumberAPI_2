package stepDefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    public static void set_the_stage() {
        System.out.println("TEST VAO DAY");
        OnStage.setTheStage(new OnlineCast());
        System.setProperty("webdriver.http.factory","jdk-http-client");
    }

}
