package br.com.dev.ednascimento.school.domain;

import java.util.*;

public class EventPublisher {

    private final List<Observable> observables = new ArrayList<>();

    public void add(Observable observable) {
        this.observables.add(observable);
    }

    public void publish(Event event) {
        this.observables.forEach( observable -> observable.process(event));
    }
}