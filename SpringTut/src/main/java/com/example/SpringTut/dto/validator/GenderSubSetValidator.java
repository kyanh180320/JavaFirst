package com.example.SpringTut.dto.validator;

import java.util.Arrays;

import com.example.SpringTut.util.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class GenderSubSetValidator implements ConstraintValidator<GenderSubset, Gender> {
    private Gender[] genders;

    @Override
    public void initialize(GenderSubset constraint) {
        this.genders = constraint.anyOf();
    }

    @Override
    public boolean isValid(Gender value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(genders).contains(value);
    }
}