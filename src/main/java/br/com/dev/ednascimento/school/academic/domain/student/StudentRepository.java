package br.com.dev.ednascimento.school.academic.domain.student;


import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;

import java.util.*;

public interface StudentRepository {
    void save(Student student);
    Optional<Student> findToNationalIdentification(NationalIdentification nationalIdentification);
    Optional<List<Student>> findAllRegisters();
}