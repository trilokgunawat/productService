package com.trilok.productservice.InheritanceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mapped_TA")
public class TA extends User {
    private double rating;

}
