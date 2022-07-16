package kimshop.domain.member;

import kimshop.dto.MemberDto;
import kimshop.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter
@ToString
@Builder
public class MemberEntity {

    @Id
    @Column(name = "meber_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mname;

    @Column(unique = true)
    private String memail;


    private String mpassword;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;


}
