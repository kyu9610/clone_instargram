package clone.instargram.web.dto;

import clone.instargram.domain.user.User;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserProfileDto {
    private boolean loginUser;
    private boolean follow;
    private User user;

}
