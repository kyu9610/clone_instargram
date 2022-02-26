package clone.instargram.service;

import clone.instargram.config.auth.PrincipalDetails;
import clone.instargram.domain.user.User;
import clone.instargram.domain.user.UserRepository;
import clone.instargram.web.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void update(UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = userRepository.findByEmail(principalDetails.getUser().getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.update(
                encoder.encode(userUpdateDto.getPassword()),
                userUpdateDto.getPhone(),
                userUpdateDto.getName(),
                userUpdateDto.getTitle(),
                userUpdateDto.getWebsite(),
                userUpdateDto.getProfileImgUrl()
        );
    }

    public User getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }
}
