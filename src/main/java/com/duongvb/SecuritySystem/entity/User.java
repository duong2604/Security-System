package com.duongvb.SecuritySystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity()
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "username", length = 50, nullable = false)
    String username;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    String email;

    @Column(name = "password", length = 255, nullable = false)
    String password;

}
