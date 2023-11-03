package com.trilok.productservice.InheritanceExample.JoinTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User{
    private int numOfSessions;
    private int numOfMentees;
}
