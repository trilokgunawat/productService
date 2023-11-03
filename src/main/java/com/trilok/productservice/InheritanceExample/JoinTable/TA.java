package com.trilok.productservice.InheritanceExample.JoinTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "join_TA")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User{
    private double rating;
}
