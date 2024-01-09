package br.com.dev.ednascimento.school.academic.infra.student;

import br.com.dev.ednascimento.school.academic.domain.student.*;
import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Optional.of;

@Repository
public class StudentRepositoryJDBCImpl implements StudentRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(Student student) {
        var sql =
                  """
                  INSERT INTO student(national_identification, name, email)
                  VALUES(:national_identification,:name, :email)
                  """;
        var parameters = new MapSqlParameterSource()
                .addValue("national_identification", student.getNationalIdentification().getCPF())
                .addValue("name", student.getName())
                .addValue("email", student.getEmail().getAddress());
        jdbcTemplate.update(sql, parameters);
    }

    @Override
    public Optional<Student> findToNationalIdentification(NationalIdentification nationalIdentification) {
        var sql =
                """
                SELECT national_identification, name, email
                FROM student
                WHERE national_identification = :national_identification
                """;
        var parameters = new MapSqlParameterSource()
                .addValue("national_identification", nationalIdentification);
        return returnStream(sql, parameters).findFirst();
    }

    @Override
    public Optional<List<Student>> findAllRegisters() {
        var sql =
                """
                SELECT national_identification, name, email
                FROM student
                """;
        return of(returnStream(sql, new MapSqlParameterSource()).toList());
    }

    private Stream<Student> returnStream(String sql, MapSqlParameterSource parameters) {
        return jdbcTemplate.query(sql, parameters, StudentRepositoryJDBCImpl::mapRow).stream();
    }

    private static Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Student(
                new NationalIdentification(resultSet.getString("national_identification")),
                resultSet.getString("name"),
                new Email(resultSet.getString("email")));
    }
}