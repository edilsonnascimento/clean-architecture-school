package br.com.dev.ednascimento.school.app.enrolled;

import br.com.dev.ednascimento.school.domain.EventPublisher;
import br.com.dev.ednascimento.school.domain.student.*;

public class StudentEnrolled {

    private final StudentRepository repository;
    private final EventPublisher publisher;

    public StudentEnrolled(StudentRepository repository, EventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public void register(StudentDto studentDto) {
        var student = studentDto.mapToStudent();
        repository.save(student);
        publisher.publish(new RegisteredStudent(student.getNationalIdentification()));
    }
}
