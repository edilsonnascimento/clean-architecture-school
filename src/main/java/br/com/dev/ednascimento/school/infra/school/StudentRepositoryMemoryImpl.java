package br.com.dev.ednascimento.school.infra.school;

import br.com.dev.ednascimento.school.domain.student.*;

import java.util.*;

public class StudentRepositoryMemoryImpl implements StudentRepository {

    private List<Student> studentsEnrolled = new ArrayList<>();

    @Override
    public void save(Student student) {
        studentsEnrolled.add(student);
    }

    @Override
    public Optional<Student> findToNationalIdentification(NationalIdentification nationalIdentification) {
        return studentsEnrolled.stream()
                .filter(student -> student.getNationalIdentification().getCPF().equals(nationalIdentification.getCPF()))
                .findFirst();
    }

    @Override
    public Optional<List<Student>> findAllRegisters() {
        return Optional.of(studentsEnrolled);
    }
}
