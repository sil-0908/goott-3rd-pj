package com.goott.pj3.common.util;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
//2023.04.18 길영준 Auth 어노테이션 등록
@Retention(RUNTIME)
@Target(METHOD)
public @interface Auth {
    public enum Role {ADMIN,USER,PLANNER}
    public Role role() default Role.USER;
}
