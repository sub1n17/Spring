package org.example.ch09.service;

import lombok.RequiredArgsConstructor;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO register(UserDTO dto) {
        // 비밀번호 암호화
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        User savedUser = userRepository.save(dto.toEntity());
        return savedUser.toDTO();
    }

    public void getUser() {
    }

    public void getUserAll() {
    }

    public void modify() {
    }

    public void remove() {
    }


}
