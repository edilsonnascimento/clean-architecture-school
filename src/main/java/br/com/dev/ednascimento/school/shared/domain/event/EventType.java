package br.com.dev.ednascimento.school.shared.domain.event;

public enum EventType {
    ENROLLED_STUDENT;

    public boolean isEnrolledStudent() {
        return this.equals(ENROLLED_STUDENT);
    }
}
