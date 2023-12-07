package br.com.dev.ednascimento.school.domain.student;

public interface EncryptPassword {

    String encrypt(String password);
    boolean checkPassword(String password, String encryptPassword);
}