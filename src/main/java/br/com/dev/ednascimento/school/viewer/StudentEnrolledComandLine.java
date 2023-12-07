package br.com.dev.ednascimento.school.viewer;

import br.com.dev.ednascimento.school.app.recommendation.*;
import br.com.dev.ednascimento.school.infra.school.StudentRepositoryMemoryImpl;

public class StudentEnrolledComandLine {

    public static void main(String[] args) {
        var name = "Fulano da Silva";
        var cpf = "123.456.789-00";
        var email = "fulano@email.com";

        var enrolled = new StudentEnrolled(new StudentRepositoryMemoryImpl());
        enrolled.register(new StudentDto(name, cpf, email));
    }
}