package br.com.dev.ednascimento.school.game.app;


import br.com.dev.ednascimento.school.game.domain.stamp.*;
import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;
import br.com.dev.ednascimento.school.shared.domain.event.*;

public class GeneratesNewStudentStamp extends Observable {

    private final StampRepository stampRepository;

    public GeneratesNewStudentStamp(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }

    @Override
    public boolean isProcess(Event event) {
        return event.getEventType().isEnrolledStudent();
    }

    @Override
    public void execute(Event event) {
        var cpf = (NationalIdentification) event.getData().get("cpf");
        var newStudent = new Stamp(cpf, "New Student");
        stampRepository.add(newStudent);
    }
}
