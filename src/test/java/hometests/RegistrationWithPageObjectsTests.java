package hometests;

import org.junit.jupiter.api.Test;

import java.io.File;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
        String firstName = "Masha";
        String lastName = "Mezentseva";
        String email = "masha@masha.com";
        String gender = "Female";
        String phone = "1234567890";
        String dayBirth = "30";
        String monthBirth = "July";
        String yearBirth = "2008";
        String subject = "Chemistry";
        String hobby = "Reading";
        File picture = new File("src/test/resources/orange.jpg");
        String address = "Novosibirsk, street X";
        String state = "Haryana";
        String city = "Karnal";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city);

        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture.getName())
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        registrationPage.clickClose();
    }
}
