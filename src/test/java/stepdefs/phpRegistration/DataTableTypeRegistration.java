package stepdefs.phpRegistration;

import io.cucumber.java.DataTableType;
import phptravels.RegistrationFormData;

import java.util.Map;

public class DataTableTypeRegistration {
    @DataTableType
    public RegistrationFormData registrationForm(Map<String, String> entry) {
        return new RegistrationFormData(
                entry.get("firstName"),
                entry.get("lastName"),
                entry.get("phone"),
                entry.get("email"),
                entry.get("password"));
    }
}
