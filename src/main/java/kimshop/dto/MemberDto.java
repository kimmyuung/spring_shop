package kimshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String mname;
    private String memail;
    private String mpassword;
    private String address;
    private String role;
}
