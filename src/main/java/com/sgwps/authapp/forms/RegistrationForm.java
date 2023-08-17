package com.sgwps.authapp.forms;



import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

    @Size(min = 4, max = 15)
    private String username;

    @Size(min = 4, max = 15)
    private String password;

    @Size(min = 4, max = 15)
    private String passwordConfirmation;

    @AssertTrue
    private boolean passwordsEqual() {
        return password.equals(passwordConfirmation);
    }
}
