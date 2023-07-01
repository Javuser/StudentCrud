package com.example.studentcrud;

import com.example.studentcrud.entity.User;
import com.example.studentcrud.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void test(){
        User user = new User();
        user.setEmail("abu@gmail.com");
        user.setPassword("34455");
        user.setFirstName("Abu");
        user.setLastName("Muslim");

        User savedUser = repository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void test2(){
        Iterable<User> users = repository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User  user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test3(){
        Integer id = 4;
        Optional<User> optionalUser = repository.findById(id);
        User user = optionalUser.get();

        user.setId(1);
        repository.save(user);

        User updatedUser = repository.findById(id).get();
        Assertions.assertThat(updatedUser.getId()).isEqualTo(4);
    }
    @Test
    public void test4() {
        Integer id = 2;
        Optional<User> user1 = repository.findById(id);
        Assertions.assertThat(user1).isPresent();
        System.out.println(user1.get());

    }

    @Test
    public void test5(){
        Integer id = 3;
        repository.deleteById(id);

        Optional<User> optionalUser = repository.findById(id);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
    @Test
    public void test6(){
        Integer id = 4;

    }
}
