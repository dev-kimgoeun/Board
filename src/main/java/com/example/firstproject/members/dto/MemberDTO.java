package com.example.firstproject.members.dto;

import com.example.firstproject.members.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberDTO {

    private Long id;
    private String email;
    private String password;

    public Member toEntity(){

        return new Member(id,email,password);
     }
}
