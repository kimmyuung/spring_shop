package kimshop.domain.member;

import kimshop.dto.MemberDto;
import kimshop.domain.member.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter
@ToString
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

    public static MemberEntity createMember(MemberDto memberDto,
                                      PasswordEncoder passwordEncoder)
    {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMname(memberDto.getMname());
        memberEntity.setMemail(memberDto.getMemail());
        memberEntity.setAddress(memberDto.getAddress());
        String password = passwordEncoder.encode(memberDto.getMpassword());
        memberEntity.setMpassword(password);
        memberEntity.setRole(Role.USER);
        return memberEntity;
    }
}
