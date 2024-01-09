package br.com.dev.ednascimento.school.academic.domain.student;

import java.security.NoSuchAlgorithmException;

public interface EncryptPassword {

    String encrypt(String password) throws NoSuchAlgorithmException;
    boolean checkPassword(String password, String encryptPassword);
}