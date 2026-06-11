package com.java.spring.ecomerce.entity;
import com.java.spring.ecomerce.enums.Gender;
import com.java.spring.ecomerce.enums.Status;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Gender gender;
    private Status status; //backend operation
    private LocalDateTime createdAt;// backend operation
    private LocalDateTime lastLoggedInAt;// backend Operation

}