package com.example.xtremepush.task;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.xtremepush.task.Model.User;
import com.example.xtremepush.task.Service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTesting {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetAgeDifference() throws Exception {
        User userOne = new User();
        User.Dob dobOne = new User.Dob();
        dobOne.setAge(30);
        userOne.setDob(dobOne);
        User.Name nameOne = new User.Name();
        nameOne.setFirst("John");
        nameOne.setLast("Doe");
        userOne.setName(nameOne);

        User userTwo = new User();
        User.Dob dobTwo = new User.Dob();
        dobTwo.setAge(25);
        userTwo.setDob(dobTwo);
        User.Name nameTwo = new User.Name();
        nameTwo.setFirst("Jane");
        nameTwo.setLast("Smith");
        userTwo.setName(nameTwo);

        when(userService.getUser("user1Seed")).thenReturn(userOne);
        when(userService.getUser("user2Seed")).thenReturn(userTwo);

        mockMvc.perform(get("/api/age-difference")
                .param("user1", "user1Seed")
                .param("user2", "user2Seed"))
                .andExpect(status().isOk())
                .andExpect(content().string("The age difference between John Doe and Jane Smith is 5 years."));
    }
}
