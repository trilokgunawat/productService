package com.trilok.productservice.clients.authenticationClient.dtos;

//import com.example.authenticationservice.models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDto {
    private UserDto userDto;
    private SessionStatus sessionStatus;
}
