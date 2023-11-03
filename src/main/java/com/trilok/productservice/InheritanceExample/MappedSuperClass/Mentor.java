package com.trilok.productservice.InheritanceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mapped_mentor")
public class Mentor extends User {
    private int numOfSessions;
    private int numberOfMentees;

}
