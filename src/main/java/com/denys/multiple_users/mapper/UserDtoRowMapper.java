package com.denys.multiple_users.mapper;

import com.denys.multiple_users.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDtoRowMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserDto.builder()
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .build();
    }
}
