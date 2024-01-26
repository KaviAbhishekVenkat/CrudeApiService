package com.kav.CrudeApiService.services;

import com.kav.CrudeApiService.annotation.TrackExecutionTIme;
import com.kav.CrudeApiService.dto.UserDetailsDto;
import com.kav.CrudeApiService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @TrackExecutionTIme
    public UserDetailsDto saveUser(UserDetailsDto dto) {
        return repo.save(dto);
    }

    public List<UserDetailsDto> saveUsers(List<UserDetailsDto> dto) {
        return repo.saveAll(dto);
    }

    public List<UserDetailsDto> getUsers() {
        return repo.findAll();
    }

    public UserDetailsDto getUserByID(String id) {
        return repo.findById(id).orElse(null);
    }

    public UserDetailsDto getUserByEmail(String email) {
        return repo.findByUserEmail(email);
    }

    public String deleteProduct(String id) {
        repo.deleteById(id);
        return "done";
    }

    public UserDetailsDto updateUser(UserDetailsDto user) {
        UserDetailsDto dto = repo.findById(user.getUserId()).orElse(null);
        dto.setUserName("sdsdsds");
        return repo.save(dto);
    }
}
