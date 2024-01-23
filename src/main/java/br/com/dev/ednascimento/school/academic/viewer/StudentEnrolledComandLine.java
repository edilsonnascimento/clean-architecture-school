package br.com.dev.ednascimento.school.academic.viewer;

import br.com.dev.ednascimento.school.academic.app.enrolled.*;
import br.com.dev.ednascimento.school.shared.domain.event.EventPublisher;
import br.com.dev.ednascimento.school.academic.infra.student.StudentRepositoryMemoryImpl;

public class StudentEnrolledComandLine {

    public static void main(String[] args) {
        var name = "Fulano da Silva";
        var cpf = "123.456.789-00";
        var email = "fulano@email.com";
        var publisher = new EventPublisher();


        var enrolled = new StudentEnrolled(new StudentRepositoryMemoryImpl(), publisher);
        enrolled.register(new StudentDto(name, cpf, email));
    }
}