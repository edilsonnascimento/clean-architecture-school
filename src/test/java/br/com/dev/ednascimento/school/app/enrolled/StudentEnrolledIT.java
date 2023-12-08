package br.com.dev.ednascimento.school.app.enrolled;

import br.com.dev.ednascimento.school.domain.student.*;
import br.com.dev.ednascimento.school.infra.school.StudentRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentEnrolledIT {

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
        var repository = new StudentRepositoryMemoryImpl();
        var service = new StudentEnrolled(repository);

        // When
        service.register(studentDto);
        var actual = repository.findToNationalIdentification(nationalIdentification).get();

        // Then
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getEmail().getAddress()).isEqualTo(expected.getEmail().getAddress());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
        assertThat(actual.getNationalIdentification().getCPF()).isEqualTo(expected.getNationalIdentification().getCPF());
    }
}