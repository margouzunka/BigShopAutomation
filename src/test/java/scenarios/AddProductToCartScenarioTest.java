package scenarios;

import steps.SearchAndCartSteps;

public class AddProductToCartScenarioTest extends BaseScenario<SearchAndCartSteps> {
    @Override
    public String getScenarioPath() {
        return "scenarios/add_product_to_cart.story";
    }
}
