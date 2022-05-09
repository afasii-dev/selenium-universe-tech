package phptravels;

import lombok.Getter;

@Getter
public class RegistrationFormData {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    public RegistrationFormData(String firstName, String lastName, String phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        if (email == null) {
            email = "";
        }
        this.email = email;
        this.password = password;
    }
}
