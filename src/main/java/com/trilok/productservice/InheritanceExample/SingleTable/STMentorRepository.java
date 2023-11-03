package com.trilok.productservice.InheritanceExample.SingleTable;

import com.trilok.productservice.InheritanceExample.JoinTable.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface STMentorRepository extends JpaRepository<Mentor, Long> {
 Mentor save(Mentor mentor);
    Mentor findMentorById(Long id);
    

}
