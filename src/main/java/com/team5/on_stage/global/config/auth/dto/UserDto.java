package com.team5.on_stage.global.config.auth.dto;

import com.team5.on_stage.user.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Role role;

    private String name;

    private String username;
}
