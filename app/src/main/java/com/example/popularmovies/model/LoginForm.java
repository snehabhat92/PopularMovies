package com.example.popularmovies.model;


import android.util.Patterns;

import com.example.popularmovies.BR;
import com.example.popularmovies.R;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

public class LoginForm extends BaseObservable {
    private LoginUser fields = new LoginUser();
    private LoginErrorFields errors = new LoginErrorFields();
    private MutableLiveData<LoginUser> buttonClick = new MutableLiveData<>();

    @Bindable
    public boolean isValid() {
        boolean valid = isEmailValid(false);
        valid = isPasswordValid(false) && valid;
        notifyPropertyChanged(BR.emailError);
        notifyPropertyChanged(BR.passwordError);
        return valid;
    }

    public boolean isEmailValid(boolean setMessage) {
        // Minimum a@b.c
        String email = fields.getUserEmail();

        if (email != null) {
            boolean validEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches();
            if (validEmail) {
                errors.setEmail(null);
                notifyPropertyChanged(BR.valid);
                return true;
            } else {
                if (setMessage) {
                    errors.setEmail(R.string.email_error);
                    notifyPropertyChanged(BR.valid);
                }
                return false;
            }
        }
        if (setMessage) {
            errors.setEmail(R.string.email_error);
            notifyPropertyChanged(BR.valid);
        }

        return false;
    }

    public boolean isPasswordValid(boolean setMessage) {
        String password = fields.getUserPassword();
        if (password != null && password.length() >= 6 && password.length() <= 12) {
            errors.setPassword(null);
            notifyPropertyChanged(BR.valid);
            return true;
        } else {
            if (setMessage) {
                errors.setPassword(R.string.password_error);
                notifyPropertyChanged(BR.valid);
            }

            return false;
        }
    }

    public void onClick() {
        if (isValid()) {
            buttonClick.setValue(fields);
        }
    }

    public MutableLiveData<LoginUser> getLoginFields() {
        return buttonClick;
    }

    public LoginUser getFields() {
        return fields;
    }

    @Bindable
    public Integer getEmailError() {
        return errors.getEmail();
    }

    @Bindable
    public Integer getPasswordError() {
        return errors.getPassword();
    }
}
