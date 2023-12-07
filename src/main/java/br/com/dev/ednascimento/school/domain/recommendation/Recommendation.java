package br.com.dev.ednascimento.school.domain.recommendation;

import br.com.dev.ednascimento.school.domain.student.Student;

import java.time.LocalDateTime;

public class Recommendation {

    private final Student indicated;
    private final Student indicator;
    private final LocalDateTime recommendationDate;

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
