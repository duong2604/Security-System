package com.duongvb.SecuritySystem.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @NotEmpty(message = "INVALID_USERNAME")
    String username;

    @NotEmpty(message = "INVALID_EMAIL")
    String email;

    @NotEmpty(message = "INVALID_PASSWORD")
    @Size(min = 8, max = 20, message = "INVALID_PASSWORD")
    String password;

}
