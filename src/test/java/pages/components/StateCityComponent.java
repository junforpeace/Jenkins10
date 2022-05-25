package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {

    public void setStateCity(String state, String city) {
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText(state)).click();
        $("#city").scrollIntoView(true).click();
        $("#city").$(byText(city)).click();
    }
}
