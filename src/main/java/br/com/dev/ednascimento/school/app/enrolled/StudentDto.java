package br.com.dev.ednascimento.school.app.enrolled;

import br.com.dev.ednascimento.school.domain.student.*;

public record StudentDto(
        String name,
        String cpf,
        String email) {

    public Student mapToStudent() {
        return new Student(new NationalIdentification(cpf), name, new Email(email));
    }
}