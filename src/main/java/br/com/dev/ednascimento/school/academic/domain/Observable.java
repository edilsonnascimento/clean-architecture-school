package br.com.dev.ednascimento.school.academic.domain;

public abstract class Observable {

    public void process(Event event) {
        if(this.isProcess(event))
            this.execute(event);
    }

    public abstract boolean isProcess(Event event);

    public abstract void execute(Event event);
}