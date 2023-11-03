package com.trilok.productservice.InheritanceExample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_Mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private int numOfSessions;
    private int numberOfMentees;

}
