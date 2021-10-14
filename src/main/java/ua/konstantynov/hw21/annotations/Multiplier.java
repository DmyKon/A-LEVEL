package ua.konstantynov.hw21.annotations;

import ua.konstantynov.hw21.objects.MathOperations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Multiplier {
    MathOperations value() default MathOperations.MULTIPLY;
}