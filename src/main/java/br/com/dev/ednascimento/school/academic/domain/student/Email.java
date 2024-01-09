package br.com.dev.ednascimento.school.academic.domain.student;

public class Email {
    private String address;

    public Email(String address) {
        validEmail(address);
        this.address = address;
    }

    private static void validEmail(String address) {
        var regularExpression = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (address == null || !address.matches(regularExpression))
            throw new IllegalArgumentException("E-mail inválido!");
    }

    public String getAddress() {
        return address;
    }
}