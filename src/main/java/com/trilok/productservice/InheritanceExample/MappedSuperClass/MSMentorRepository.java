package com.trilok.productservice.InheritanceExample.MappedSuperClass;

import com.trilok.productservice.InheritanceExample.JoinTable.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSMentorRepository extends JpaRepository<Mentor, Long> {
   Mentor save(Mentor mentor);
    Mentor findMentorById(Long id);
    

}
