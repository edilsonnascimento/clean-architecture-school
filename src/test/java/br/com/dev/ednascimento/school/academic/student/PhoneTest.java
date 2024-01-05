package br.com.dev.ednascimento.school.academic.student;

import br.com.dev.ednascimento.school.academic.domain.student.Phone;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PhoneTest {

    @ParameterizedTest
    @MethodSource("validDataProvider")
    void GIVEN_valid_Phone_MUST_create(String ddd, String number) {

        // Given
        var domain = new Phone(ddd, number);
        var expected = ddd + number;

        // When
        var actual = domain.fullPhone();

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inValidDataProvider")
    void GIVEN_invalid_Phone_THEN_throws_Expcetion(String ddd, String number) {

        // Given
        var expected = "Invalid Phone!";

        // When
        var actual = assertThrows(IllegalArgumentException.class, () -> new Phone(ddd, number));

        // Then
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    private static Stream<Arguments> validDataProvider() {
        return Stream.of(
                arguments("(12)", "3456-7890"),
                arguments("21", "1234-5678"),
                arguments("(21)", "12345678"),
                arguments("21", "12345678"),
                arguments("11.", "98765.4321"),
                arguments("11.", "98765-4321"),
                arguments("11-", "98765.4321"));
    }

    private static Stream<Arguments> inValidDataProvider() {
        return Stream.of(
                arguments("11)", "98765-4321"),
                arguments("(11", "98765-4321"),
                arguments("", "3456-7890"),
                arguments("21", ""),
                arguments("11", "7654321"),
                arguments(null, "98765-4321"),
                arguments("11.", null),
                arguments(null, null));
    }

}