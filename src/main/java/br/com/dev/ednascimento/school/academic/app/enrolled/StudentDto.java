package br.com.dev.ednascimento.school.academic.app.enrolled;


import br.com.dev.ednascimento.school.academic.domain.student.*;
import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;

public record StudentDto(
        String name,
        String cpf,
        String email) {

    public Student mapToStudent() {
        return new Student(new NationalIdentification(cpf), name, new Email(email));
    }
}