package com.angularSpring.Categorys.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter

public class ValidationErros extends StandartError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationErros() {

    }

    public ValidationErros(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);

    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
