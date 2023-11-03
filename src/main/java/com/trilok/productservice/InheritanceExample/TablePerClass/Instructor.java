package com.trilok.productservice.InheritanceExample.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tablePerClass_Instructor")
public class Instructor extends User {

    private boolean isHandsome;
}
