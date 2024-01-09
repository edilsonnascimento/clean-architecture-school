package br.com.dev.ednascimento.school.stamp.stamp;


import br.com.dev.ednascimento.school.academic.domain.student.NationalIdentification;

import java.util.List;

public interface StampRepository {

    void add(Stamp stamp);
    List<Stamp> stampOfStudent(NationalIdentification nationalIdentification);
}