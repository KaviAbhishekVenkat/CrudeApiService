package com.kav.CrudeApiService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class UserDetailsDto {
    @Id
    @NotNull(message = "Id Cannot be null")
    String userId;
    @NotEmpty(message = "Name cannot be null or balnk")
    String userName;
    @Email
    String userEmail;
}
