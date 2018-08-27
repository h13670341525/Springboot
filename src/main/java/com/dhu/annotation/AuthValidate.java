package com.dhu.annotation;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AuthValidate {
    int value() default 1;
}
