package br.com.dev.ednascimento.school.academic.student;

import br.com.dev.ednascimento.school.academic.domain.student.*;
import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    @Test
    void SHOULD_throw_exception_WHEN_tries_to_add_more_than_two_phones() {

        // Given
        var student = new Student(new NationalIdentification("000.000.000-00"), "Tom", new Email("tom@email.com"));
        var ddd = "055";
        var phone1 = "9999-9999";
        var phone2 = "8888-8888";
        var phone3 = "7777-7777";
        var expected = "exceeded the maximum number of reported telephone numbers";


        // When
        student.addPhone(ddd, phone1);
        student.addPhone(ddd, phone2);
        var actual = assertThrows(BusinessException.class, () -> student.addPhone(ddd, phone3));

        // Then
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

}