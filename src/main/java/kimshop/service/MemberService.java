package kimshop.service;

import kimshop.domain.member.MemberEntity;
import kimshop.domain.member.MemberRepository;
import kimshop.domain.member.Role;
import kimshop.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService implements OAuth2UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto){
        String password = passwordEncoder.encode(memberDto.getMpassword());
        MemberEntity memberEntity = MemberEntity.builder()
                        .memail(memberDto.getMemail())
                                .address(memberDto.getAddress())
                                        .role(Role.USER)
                                                .mname(memberDto.getMname())
                                                        .mpassword(password)
                                                                .build();
        memberRepository.save(memberEntity);
        return true;
    }

    public boolean signupcheck(MemberDto memberDto) {
        Optional<MemberEntity> optional = memberRepository.findByEmail(memberDto.getMemail());
        MemberEntity memberEntity = null;
       if(optional.isPresent()) {
            memberEntity = optional.get();
            return true; // 중복이 있음 가입 불가능
       }
        return false; // 중복이 없음 가입 가능
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return null;
    }
}
