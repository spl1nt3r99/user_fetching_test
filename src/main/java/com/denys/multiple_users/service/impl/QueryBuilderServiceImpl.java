package com.denys.multiple_users.service.impl;

import com.denys.multiple_users.config.DataSources;
import com.denys.multiple_users.dto.UserFilterDto;
import com.denys.multiple_users.service.QueryBuilderService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
public class QueryBuilderServiceImpl implements QueryBuilderService {

    @Override
    public String getUsersQuery(DataSources.Source source, UserFilterDto filterDto) {
        var sqlTemplate = "SELECT %s as id, %s as username, %s as name, %s as surname FROM %s";
        var sql = String.format(
                sqlTemplate,
                source.mapping().id(),
                source.mapping().username(),
                source.mapping().name(),
                source.mapping().surname(),
                source.table()
        );

        var predicates = new ArrayList<String>();

        if (filterDto.getId() != null) {
            predicates.add(source.mapping().id() + " = " + filterDto.getId());
        }
        if (StringUtils.hasText(filterDto.getUsername())) {
            predicates.add(source.mapping().username() + " = '" + filterDto.getUsername() + "'");
        }
        if (StringUtils.hasText(filterDto.getName())) {
            predicates.add(source.mapping().name() + " = '" + filterDto.getName() + "'");
        }
        if (StringUtils.hasText(filterDto.getSurname())) {
            predicates.add(source.mapping().surname() + " = '" + filterDto.getSurname() + "'");
        }

        if (!predicates.isEmpty()) {
            sql += " WHERE " + String.join(" AND ", predicates);
        }

        return sql;
    }
}
