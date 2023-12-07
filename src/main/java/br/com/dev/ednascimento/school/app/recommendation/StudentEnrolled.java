package br.com.dev.ednascimento.school.app.recommendation;

import br.com.dev.ednascimento.school.domain.student.StudentRepository;

public class StudentEnrolled {

    private final StudentRepository repository;

    public StudentEnrolled(StudentRepository repository) {
        this.repository = repository;
    }

    public void register(StudentDto studentDto) {
        var student = studentDto.mapToStudent();
        repository.save(student);
    }
}
