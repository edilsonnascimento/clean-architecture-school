package br.com.dev.ednascimento.school.domain.student;

import br.com.dev.ednascimento.school.domain.*;

import java.time.format.DateTimeFormatter;

public class LogRegisteredStudent extends Observable {

    @Override
    public boolean isProcess(Event event) {
        return event instanceof RegisteredStudent;
    }

    @Override
    public void execute(Event event) {
        var instantFormatted = event.instant().format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(String.format("Student com CPF %s register in: %s",
                ((RegisteredStudent) event).getNationalIdentification(),
                instantFormatted));
    }

}