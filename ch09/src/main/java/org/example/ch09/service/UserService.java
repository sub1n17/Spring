package org.example.ch09.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    public UserDTO getUser(String userid){

        Optional<User> optUser1 = repository.findById(userid);

        if(optUser1.isPresent()){
            User entity = optUser1.get();
            return entity.toDTO();
        }
        return null;
    }

    public List<UserDTO> getUserAll(){

        List<User> entityList = repository.findAll();

        return entityList
                .stream()
                .map(entity -> entity.toDTO())
                .toList();
    }

    public UserDTO register(UserDTO dto){

        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        User savedEntity = repository.save(dto.toEntity());

        return savedEntity.toDTO();
    }

    public UserDTO modify(UserDTO dto){

        if(repository.existsById(dto.getUserid())){
            User modifiedUser1 = repository.save(dto.toEntity());
            return modifiedUser1.toDTO();
        }
        return null;
    }

    public boolean remove(String userid){

        if(repository.existsById(userid)) {
            repository.deleteById(userid);
            return true;
        }
        return false;
    }
}