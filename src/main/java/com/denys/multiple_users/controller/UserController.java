package com.denys.multiple_users.controller;

import com.denys.multiple_users.dto.UserDto;
import com.denys.multiple_users.dto.UserFilterDto;
import com.denys.multiple_users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Retrieve users from all sources",
            description = "Retrieving users by default or by filtering")
    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))})
    public ResponseEntity<List<UserDto>> getUsers(
            @Parameter(description = "id of user to be retrieved")
            @RequestParam(required = false) Long id,
            @Parameter(description = "username of user to be retrieved")
            @RequestParam(required = false) String username,
            @Parameter(description = "name of user to be retrieved")
            @RequestParam(required = false) String name,
            @Parameter(description = "surname of user to be retrieved")
            @RequestParam(required = false) String surname
    ) {
        var filterDto = UserFilterDto.builder()
                .id(id)
                .username(username)
                .name(name)
                .surname(surname)
                .build();

        return ResponseEntity.ok(userService.getUsers(filterDto));
    }
}
