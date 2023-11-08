package com.wendy.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/8 0:03
 * @Version 1.0
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, String> {
    private String[] values;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        List<String> list = Arrays.stream(values).collect(Collectors.toList());
        if (list.contains(o)) {
            return true;
        }
        return false;
    }
}
