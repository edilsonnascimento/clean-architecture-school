package br.com.dev.ednascimento.school;

public class CPF {

    private String cpf;

    public CPF(String cpf) {
        validateCpf(cpf);
        this.cpf = cpf;
    }

    private void validateCpf(String cpf) {
        var regularExpression = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        if (cpf == null ||
            !cpf.matches(regularExpression))
            throw new IllegalArgumentException("Invalid CPF!");
    }
}
