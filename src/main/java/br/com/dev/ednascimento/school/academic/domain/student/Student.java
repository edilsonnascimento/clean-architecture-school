package br.com.dev.ednascimento.school.academic.domain.student;

import br.com.dev.ednascimento.school.shared.domain.NationalIdentification;

import java.util.*;

public class Student {
    private NationalIdentification nationalIdentification;
    private String name;
    private Email email;
    private String password;
    private List<Phone> phones = new ArrayList<>();

    public Student(NationalIdentification nationalIdentification, String name, Email email) {
        this.nationalIdentification = nationalIdentification;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String ddd, String number) {
        if(phones.size() == 2)
            throw new BusinessException("exceeded the maximum number of reported telephone numbers");
        this.phones.add(new Phone(ddd, number));
    }

    public NationalIdentification getNationalIdentification() {
        return nationalIdentification;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public String getPassword() {
        return this.password;
    }

}