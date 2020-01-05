package com.kal.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션이 유효한 위치 지정 이 경우에는 파라미터로 선언된 객체에서만 사용할 수 있다
@Retention(RetentionPolicy.RUNTIME) // 컴파일 이휴에도 JVM 에 의해서 참조가 가능하다.
public @interface LoginUser {
        // @interface 이 파일을 어노테이션 클래스로 지정한다.
}

