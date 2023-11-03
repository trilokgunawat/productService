package com.trilok.productservice.InheritanceExample.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TablePerClass_Mentor")
public class Mentor extends User {
    private int numOfSessions;
    private int numberOfMentees;

}
