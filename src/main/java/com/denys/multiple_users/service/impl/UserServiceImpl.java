package com.denys.multiple_users.service.impl;

import com.denys.multiple_users.config.DataSources;
import com.denys.multiple_users.dto.UserDto;
import com.denys.multiple_users.dto.UserFilterDto;
import com.denys.multiple_users.mapper.UserDtoRowMapper;
import com.denys.multiple_users.service.QueryBuilderService;
import com.denys.multiple_users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final DataSources dataSources;
    private final QueryBuilderService queryBuilderService;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserDto> getUsers(UserFilterDto filterDto) {
        var users = new ArrayList<UserDto>();
        for (DataSources.Source source : dataSources.dataSources()) {
            try {
                initJdbcTemplate(source);
                var sql = queryBuilderService.getUsersQuery(source, filterDto);
                var jdbcUsers = jdbcTemplate.query(sql, new UserDtoRowMapper());
                users.addAll(jdbcUsers);
            } catch (Exception e) {
                // Ignoring results with probably type inconsistency since it already did not match filter
                log.error(e.getMessage(), e);
            }
        }
        return users;
    }

    private void initJdbcTemplate(DataSources.Source source) {
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl(source.url());
        dataSource.setUsername(source.user());
        dataSource.setPassword(source.password());
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
