package org.example.ch07.security;

import lombok.RequiredArgsConstructor;
import org.example.ch07.entity.User;
import org.example.ch07.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    /*
        - UserDetailsService 호출하는 AuthenticationProvider에서 Username(사용자아이디)을 전달
        - AuthenticationProvider에서 실제 사용자 아이디, 비밀번호 인증을 수행
        - 인증 성공 후 loadUserByUsername 메서드의 매개변수 username으로 인증된 사용자 아이디 전달
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optUser = userRepository.findById(username);

        if (optUser.isPresent()) {
            MyUserDetails details = MyUserDetails.builder()
                    .user(optUser.get())
                    .build();

            return details;
        }

        return null;
    }
}
