package br.com.dev.ednascimento.school.game.infra;


import br.com.dev.ednascimento.school.academic.domain.student.NationalIdentification;
import br.com.dev.ednascimento.school.game.domain.stamp.*;
import br.com.dev.ednascimento.school.stamp.stamp.*;

import java.util.*;

public class StampRepositoryImpl implements StampRepository {

    private List<Stamp> stamps = new ArrayList<>();

    @Override
    public void add(Stamp stamp) {
        stamps.add(stamp);
    }

    @Override
    public List<Stamp> stampOfStudent(NationalIdentification nationalIdentification) {
        return this.stamps.stream()
                .filter(s -> s.nationalIdentification().getCPF().equals(nationalIdentification.getCPF()))
                .toList();
    }
}
