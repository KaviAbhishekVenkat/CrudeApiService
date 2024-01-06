package com.kav.CrudeApiService.repository;

import com.kav.CrudeApiService.dto.UserDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDetailsDto,String> {

    UserDetailsDto findByUserEmail(String email);
}
