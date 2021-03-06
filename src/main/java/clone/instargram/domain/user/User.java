package clone.instargram.domain.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String phone;
    private String username;
    private String title;
    private String website;
    private String profileImgUrl;

    public void update(String password,String phone, String username,String title,String website,String profileImgUrl){
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.title = title;
        this.website = website;
        this.profileImgUrl = profileImgUrl;
    }
}
