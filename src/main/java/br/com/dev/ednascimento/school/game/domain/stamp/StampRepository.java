package br.com.dev.ednascimento.school.game.domain.stamp;


import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;

import java.util.List;

public interface StampRepository {

    void add(Stamp stamp);
    List<Stamp> stampOfStudent(NationalIdentification nationalIdentification);
}