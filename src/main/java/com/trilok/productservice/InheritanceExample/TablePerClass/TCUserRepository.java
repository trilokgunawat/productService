package com.trilok.productservice.InheritanceExample.TablePerClass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TCUserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(Long  Id);
}
