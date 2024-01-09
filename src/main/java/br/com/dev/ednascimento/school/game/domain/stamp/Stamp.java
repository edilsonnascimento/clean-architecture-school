package br.com.dev.ednascimento.school.game.domain.stamp;

import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;

public record Stamp(
        NationalIdentification nationalIdentification,
        String name) {
}