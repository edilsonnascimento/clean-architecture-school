package br.com.dev.ednascimento.school.domain.student;

import java.util.*;

public interface StudentRepository {
    void register(Student student);
    Optional<Student> findToNationalIdentification(NationalIdentification nationalIdentification);
    Optional<List<Student>> findAllRegisters();
}