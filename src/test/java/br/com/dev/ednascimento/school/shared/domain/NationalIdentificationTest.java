package br.com.dev.ednascimento.school.shared.domain;

import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NationalIdentificationTest {

    @Test
    void GIVEN_valid_CPF_MUST_create() {

        // Given
        var expected = "999.999.999-99";
        var domain = new NationalIdentification(expected);

        // When
        var actual = domain.getCPF();

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inValidDataProvider")
    void GIVEN_invalid_cpf_THEN_throws_Expcetion(String cpf) {

        // Given
        var expected = "Invalid CPF!";

        // When
        var actual = assertThrows(IllegalArgumentException.class, () -> new NationalIdentification(cpf));

        // Then
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    private static Stream<Arguments> inValidDataProvider() {
        return Stream.of(arguments(""), arguments("999999999"), null);
    }

}