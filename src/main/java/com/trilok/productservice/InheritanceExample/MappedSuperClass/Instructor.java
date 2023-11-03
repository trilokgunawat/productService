package com.trilok.productservice.InheritanceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mapped_Instructor")
public class Instructor extends User {
    private boolean isHandsome;
}
