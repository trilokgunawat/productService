package com.trilok.productservice.InheritanceExample.MappedSuperClass;

import com.trilok.productservice.InheritanceExample.JoinTable.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSUserRepository extends JpaRepository<User,Long> {
  User save(User user);
    User findUserById(Long  Id);

}
