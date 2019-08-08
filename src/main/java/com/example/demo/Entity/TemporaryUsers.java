package com.example.demo.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class TemporaryUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column
    private String mobile_number;

    @Column
    private String email;

    private String code;
    private Long expire_time;
    private String default_type;

    public TemporaryUsers() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Long expire_time) {
        this.expire_time = expire_time;
    }

    public String getDefault_type() {
        return default_type;
    }

    public void setDefault_type(String default_type) {
        this.default_type = default_type;
    }
}
