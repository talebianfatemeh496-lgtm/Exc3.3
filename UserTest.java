package com.example.springbootuser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.springbootuser.User;
import com.example.springbootuser.UserRepository;

@DataJpaTest
public class UserTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        // given
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // when
        User savedUser = userRepository.save(user);

        // then
        assert savedUser != null;
        assert savedUser.getId() != null;
    }
}