package br.com.dev.ednascimento.school.recomentation;

import br.com.dev.ednascimento.school.student.Student;

import java.time.LocalDateTime;

public class Recommendation {

    private Student indicated;
    private Student indicator;
    private LocalDateTime recommendationDate;

    public Recommendation(Student indicated, Student indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.recommendationDate = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getRecommendationDate() {
        return recommendationDate;
    }
}
