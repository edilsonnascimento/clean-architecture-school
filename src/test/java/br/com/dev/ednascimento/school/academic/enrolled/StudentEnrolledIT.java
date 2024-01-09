package br.com.dev.ednascimento.school.academic.enrolled;

import br.com.dev.ednascimento.school.academic.app.enrolled.*;
import br.com.dev.ednascimento.school.academic.domain.EventPublisher;
import br.com.dev.ednascimento.school.academic.domain.student.*;
import br.com.dev.ednascimento.school.academic.infra.student.StudentRepositoryMemoryImpl;
import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class StudentEnrolledIT {


    private StudentRepositoryMemoryImpl repository;
    private StudentEnrolled service;


    @BeforeEach
    void setup() {
        var publisher = new EventPublisher();
        publisher.add(new LogRegisteredStudent());
        this.repository = new StudentRepositoryMemoryImpl();
        this.service = new StudentEnrolled(repository, publisher);
    }

    @Test
    void GIVEN_a_Valid_Student_MUST_Persist() {

        // Given
        var cpf = "123.435.334-00";
        var name = "Fulano";
        var emailDto = "fulano@gmai.com";
        var nationalIdentification = new NationalIdentification(cpf);
        var email = new Email(emailDto);
        var studentDto = new StudentDto(name,cpf, emailDto);
        var expected = new Student(nationalIdentification, name, email);

        // When
        service.register(studentDto);

        // Then
        var actual = repository.findToNationalIdentification(nationalIdentification).get();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getEmail().getAddress()).isEqualTo(expected.getEmail().getAddress());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
        assertThat(actual.getNationalIdentification().getCPF()).isEqualTo(expected.getNationalIdentification().getCPF());
    }
}