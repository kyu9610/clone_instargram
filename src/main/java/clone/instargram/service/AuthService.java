package clone.instargram.service;

import clone.instargram.domain.user.User;
import clone.instargram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User signup(User user){

        if(userRepository.findByEmail(user.getEmail()) != null){
            return null;
        }

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        User userEntity = userRepository.save(user);

        return userEntity;
    }

    @Transactional
    public User userUpdate(User user){
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
