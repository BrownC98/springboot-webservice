package com.kal.book.springboot.config.auth.dto;

import com.kal.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//user session 저장용
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
