package br.com.dev.ednascimento.school.domain.student;

public class NationalIdentification {

    private String cpf;

    public NationalIdentification(String cpf) {
        validateCpf(cpf);
        this.cpf = cpf;
    }

    private void validateCpf(String cpf) {
        var regularExpression = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        if (cpf == null || !cpf.matches(regularExpression))
            throw new IllegalArgumentException("Invalid CPF!");
    }

    public String getCPF() {
        return this.cpf;
    }
}
