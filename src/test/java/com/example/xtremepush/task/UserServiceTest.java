package com.example.xtremepush.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.xtremepush.task.Model.User;
import com.example.xtremepush.task.Model.UserResponse;
import com.example.xtremepush.task.Service.UserService;

public class UserServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUser() {
        // Arrange
        String seed = "testSeed";
        User mockUser = new User();
        User.Dob dob = new User.Dob();
        dob.setAge(52);

        mockUser.setDob(dob);

        User.Name name = new User.Name();
        name.setFirst("Endre");
        name.setLast("Doe");

        mockUser.setName(name);

        UserResponse userResponse = new UserResponse();
        userResponse.setResults(Collections.singletonList(mockUser));

        when(restTemplate.getForObject(String.format("https://randomuser.me/api/?seed=%s", seed), UserResponse.class))
                .thenReturn(userResponse);

        User user = userService.getUser(seed);
        assertEquals("Endre", user.getName().getFirst());
        assertEquals(52, user.getDob().getAge());
    }
}
