package clone.instargram.web.dto;

import clone.instargram.domain.user.User;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserLoginDto {
    private String email;
    private String password;
    private String phone;
    private String username;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .username(username)
                .build();
    }
}
