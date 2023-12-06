package br.com.dev.ednascimento.school.student;

import br.com.dev.ednascimento.school.domain.student.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EmailTest {

    @Test
    void GIVEN_valid_email_MUST_create() {

        // Given
        var expected = "valid@email.com";
        var domain = new Email(expected);

        // When
        var actual = domain.getAddress();

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inValidDataProvider")
    void GIVEN_invalid_email_THEN_throws_Expcetion(String address) {

        // Given
        var expected = "E-mail inválido!";

        // When
        var actual = assertThrows(IllegalArgumentException.class, () -> new Email(address));

        // Then
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    private static Stream<Arguments> inValidDataProvider() {
        return Stream.of(arguments(""), arguments("ivalidEmail"), null);
    }
}