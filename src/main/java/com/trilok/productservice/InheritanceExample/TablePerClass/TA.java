package com.trilok.productservice.InheritanceExample.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tablePerClass_TA")
public class TA extends User {
    private double rating;

}
