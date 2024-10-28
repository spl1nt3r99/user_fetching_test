package com.denys.multiple_users.service;

import com.denys.multiple_users.config.DataSources;
import com.denys.multiple_users.dto.UserFilterDto;

public interface QueryBuilderService {

    String getUsersQuery(DataSources.Source source, UserFilterDto filterDto);
}
