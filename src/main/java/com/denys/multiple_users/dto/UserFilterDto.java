package com.denys.multiple_users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserFilterDto {

    private Long id;
    private String username;
    private String name;
    private String surname;
}
