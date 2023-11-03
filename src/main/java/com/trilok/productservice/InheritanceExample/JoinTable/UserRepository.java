package com.trilok.productservice.InheritanceExample.JoinTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(Long  Id);

}
