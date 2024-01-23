package br.com.dev.ednascimento.school.shared.domain.event;

public abstract class Observable {

    public void process(Event event) {
        if(this.isProcess(event))
            this.execute(event);
    }

    public abstract boolean isProcess(Event event);

    public abstract void execute(Event event);
}