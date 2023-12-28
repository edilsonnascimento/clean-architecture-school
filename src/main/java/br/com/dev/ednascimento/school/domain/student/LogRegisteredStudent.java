package br.com.dev.ednascimento.school.domain.student;

import java.time.format.DateTimeFormatter;

public class LogRegisteredStudent {

    public void reactionTo(RegisteredStudent event) {
        var instantFormatted = event.instant().format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(String.format("Student com CPF %s register in: %s",
                                 event.getNationalIdentification(),
                                 instantFormatted));
    }
}
