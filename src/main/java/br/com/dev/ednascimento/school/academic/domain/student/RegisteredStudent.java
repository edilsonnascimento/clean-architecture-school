package br.com.dev.ednascimento.school.academic.domain.student;

import br.com.dev.ednascimento.school.shared.domain.event.*;
import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;

import java.time.LocalDateTime;
import java.util.*;

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

    @Override
    public EventType getEventType() {
        return EventType.ENROLLED_STUDENT;
    }

    @Override
    public Map<String, Object> getData() {
        return Map.of("CPF", this.nationalIdentification);
    }

    public NationalIdentification getNationalIdentification() {
        return nationalIdentification;
    }
}