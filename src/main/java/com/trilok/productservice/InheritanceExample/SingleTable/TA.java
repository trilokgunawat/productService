package com.trilok.productservice.InheritanceExample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_TA")
@DiscriminatorValue(value = "1")
public class TA extends User {
    private double rating;

}
