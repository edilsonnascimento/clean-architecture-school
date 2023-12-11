package br.com.dev.ednascimento.school.domain.student;

import java.io.Serial;

public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5516849839320556195L;

    public BusinessException(String message) {
        super(message);
    }
}
