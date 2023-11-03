package com.trilok.productservice.InheritanceExample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_Instructor")
@DiscriminatorValue("3")
public class Instructor extends User {
    private boolean isHandsome;
}
