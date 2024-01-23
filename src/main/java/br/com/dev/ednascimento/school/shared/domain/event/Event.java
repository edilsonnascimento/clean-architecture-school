package br.com.dev.ednascimento.school.shared.domain.event;

import java.time.LocalDateTime;
import java.util.Map;

public interface Event {
    LocalDateTime instant();
    EventType getEventType();
    Map<String, Object> getData();
}