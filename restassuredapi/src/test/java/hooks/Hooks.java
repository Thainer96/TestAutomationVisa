package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {
    Scenario scenario ;

    @Before
    public void before(Scenario scenario) throws InterruptedException {
        this.scenario = scenario;
        System.out.println("soy el escenario " + scenario.getName());
    }

    @After
    public void afterScenariosWeb() throws IOException {
        if (scenario.isFailed()){
            System.out.println("TEST FAILED, DO SNAPSHOT");
        }
    }


}
