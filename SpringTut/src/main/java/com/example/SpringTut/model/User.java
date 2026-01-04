package com.example.SpringTut.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullname", length = 100, columnDefinition = "VARCHAR(100) DEFAULT ''")
    private String fullname;

    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;

    @Column(name = "address", length = 200, columnDefinition = "VARCHAR(200) DEFAULT ''")
    private String address;

    @Column(name = "password", length = 100, nullable = false, columnDefinition = "VARCHAR(100) NOT NULL DEFAULT ''")
    private String password;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "facebook_account_id", columnDefinition = "INT DEFAULT 0")
    private Integer facebookAccountId;

    @Column(name = "google_account_id", columnDefinition = "INT DEFAULT 0")
    private Integer googleAccountId;
}
