package com.wendy.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/8 0:02
 * @Version 1.0
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValueValidator.class})
public @interface EnumValue {
    String[] values() default {};

    String message() default "值不在枚举范围内";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
