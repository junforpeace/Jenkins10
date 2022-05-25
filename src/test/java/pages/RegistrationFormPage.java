package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();
    StateCityComponent statecity = new StateCityComponent();

    //locators
    SelenideElement firstName = $("#firstName"),
                    inputGender = $("#genterWrapper"),
                    inputLastName = $("#lastName"),
                    inputEmail = $("#userEmail"),
                    inputPhone = $("#userNumber"),
                    inputAddress = $("#currentAddress"),
                    inputSubjects = $("#subjectsInput"),
                    dateOfBirth = $("#dateOfBirthInput"),
                    inputHobby = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    resultForm = $(".table-responsive"),
                    tableTitle = $("#example-modal-sizes-title-lg");



    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;

    }
    public RegistrationFormPage setFirstName(String name) {
        $(firstName).setValue(name);

        return this;
    }
    public RegistrationFormPage setLastName(String lastname) {
        $(inputLastName).setValue(lastname);

        return this;
    }
    public RegistrationFormPage setEmail(String userEmail) {
        $(inputEmail).setValue(userEmail);

        return this;
    }
    public RegistrationFormPage setGender(String gender) {
        inputGender.$(byText(gender)).click();

        return this;
    }
    public RegistrationFormPage setPhone(String phone) {
        inputPhone.setValue(phone);

        return this;
    }
    public RegistrationFormPage setCurrentAddress(String address) {
        inputAddress.setValue(address);

        return this;
    }
    public RegistrationFormPage setSubjects(String subject) {
        inputSubjects.setValue(subject).pressEnter();

        return this;
    }
    public RegistrationFormPage setBirthday(String day, String month, String year) {
        dateOfBirth.click();
        calendar.setDate(day, month, year);

        return this;
    }
    public RegistrationFormPage setHobby (String hobby) {
        inputHobby.$(byText(hobby)).click();


        return this;
    }
    public RegistrationFormPage uploadImage (String image) {
        uploadPicture.uploadFromClasspath(image);
        return this;
    }
    public RegistrationFormPage setState (String state, String city) {
        statecity.setStateCity(state, city);

        return this;
    }
    public RegistrationFormPage submitForm () {
        $("#submit").pressEnter();

        return this;
    }
    public RegistrationFormPage checkTitle(String title) {
        tableTitle.shouldHave(text(title));

        return this;
    }
    public RegistrationFormPage checkResult(String label, String value) {
        resultForm.$(byText(label))
                   .parent().shouldHave(text(value));

        return this;
    }

}
