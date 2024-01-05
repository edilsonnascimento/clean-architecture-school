package br.com.dev.ednascimento.school.academic.app.enrolled;


import br.com.dev.ednascimento.school.academic.domain.student.*;

public record StudentDto(
        String name,
        String cpf,
        String email) {

    public Student mapToStudent() {
        return new Student(new NationalIdentification(cpf), name, new Email(email));
    }
}