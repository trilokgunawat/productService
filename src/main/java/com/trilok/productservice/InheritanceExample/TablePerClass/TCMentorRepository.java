package com.trilok.productservice.InheritanceExample.TablePerClass;

import com.trilok.productservice.InheritanceExample.JoinTable.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCMentorRepository extends JpaRepository<Mentor, Long> {
   Mentor save(Mentor mentor);
    Mentor findMentorById(Long id);
    

}
