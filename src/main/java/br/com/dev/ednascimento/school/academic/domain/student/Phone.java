package br.com.dev.ednascimento.school.academic.domain.student;

import java.util.Objects;

public class Phone {
    private String ddd;
    private String number;

    public Phone(String ddd, String number) {
        validPhone(ddd, number);
        this.ddd = ddd;
        this.number = number;
    }

    private void validPhone(String ddd, String number) {
        var regularExpression = "^\\(\\d{2}\\)[-.\\s]?\\d{4,5}[-.\\s]?\\d{4}$" +
                                "|^\\d{2}[-.\\s]?\\d{4,5}[-.\\s]?\\d{4}$";
        var completedPhone = ddd + number;
        if(Objects.isNull(completedPhone) || !completedPhone.matches(regularExpression))
            throw new IllegalArgumentException("Invalid Phone!");
    }

    public String fullPhone() {
        return this.ddd + this.number;
    }
}
