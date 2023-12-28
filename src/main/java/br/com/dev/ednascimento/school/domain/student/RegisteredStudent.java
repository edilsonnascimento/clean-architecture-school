package br.com.dev.ednascimento.school.domain.student;

import br.com.dev.ednascimento.school.domain.Event;

import java.time.LocalDateTime;

public class RegisteredStudent implements Event {

    private final NationalIdentification nationalIdentification;
    private final LocalDateTime instant;

    public RegisteredStudent(NationalIdentification nationalIdentification) {
        this.nationalIdentification = nationalIdentification;
        this.instant = LocalDateTime.now();
    }

    @Override
    public LocalDateTime instant() {
        return this.instant;
    }
}