package br.com.dev.ednascimento.school.stamp.stamp;

import br.com.dev.ednascimento.school.academic.domain.student.NationalIdentification;

public record Stamp(
        NationalIdentification nationalIdentification,
        String name) {
}