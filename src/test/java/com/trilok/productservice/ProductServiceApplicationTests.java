package com.trilok.productservice;

import com.trilok.productservice.InheritanceExample.JoinTable.Mentor;
import com.trilok.productservice.InheritanceExample.JoinTable.MentorRepository;
import com.trilok.productservice.InheritanceExample.JoinTable.User;
import com.trilok.productservice.InheritanceExample.JoinTable.UserRepository;
import com.trilok.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private MentorRepository mentorRepository;
    @Test
    void contextLoads() {
    }
//    @Test
//    void testDifferentInheritances(){
//        User user = new User();
//        user.setEmail("trilokgunawat@gmail.com");
//        user.setPassword("password");
//        userRepository.save(user);
//    }


}
