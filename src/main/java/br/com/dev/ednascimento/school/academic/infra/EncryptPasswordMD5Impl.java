package br.com.dev.ednascimento.school.academic.infra;

import br.com.dev.ednascimento.school.academic.domain.student.EncryptPassword;

import java.security.*;

public class EncryptPasswordMD5Impl implements EncryptPassword {

    @Override
    public String encrypt(String password)  {
        try {
            var md5Digest = MessageDigest.getInstance("MD5");
            var md5Bytes = md5Digest.digest(password.getBytes());
            var hexStringBuilder = new StringBuilder();
            for (byte b : md5Bytes)
                hexStringBuilder.append(String.format("%02x", b));
            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generation password!");
        }
    }

    @Override
    public boolean checkPassword(String password, String encryptPassword) {
        return password.equals(encryptPassword);
    }
}