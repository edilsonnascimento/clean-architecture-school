package br.com.dev.ednascimento.school.app;

import br.com.dev.ednascimento.school.domain.student.Student;

public interface SendEmailRecommendation {
    void send(Student indicated);
}
