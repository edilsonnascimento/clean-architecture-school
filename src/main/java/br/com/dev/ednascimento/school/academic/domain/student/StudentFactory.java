package br.com.dev.ednascimento.school.academic.domain.student;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCPFEmail(String name, String cpf, String email) {
        this.student = new Student(new NationalIdentification(cpf), name, new Email(email));
        return this;
    }

    public StudentFactory withPhone(String ddd, String number) {
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student build() {
        return this.student;
    }
}