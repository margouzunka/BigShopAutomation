package scenarios;

import steps.LoginSteps;

public class LoginScenarioTest extends BaseScenario<LoginSteps> {
    @Override
    public String getScenarioPath() {
        return "scenarios/login.story";
    }
}
