package com.trilok.productservice.clients.authenticationClient.dtos;

import com.trilok.productservice.models.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role extends BaseModel {
    private String name;
}
