package com.example.xtremepush.task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xtremepush.task.Model.User;
import com.example.xtremepush.task.Service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/age-difference")
    public String getAgeDifference(@RequestParam String user1, @RequestParam String user2) {
        User userOne = userService.getUser(user1);
        System.out.println(userOne);
        User userTwo = userService.getUser(user2);
        System.out.println(userTwo);

        int ageDifference = Math.abs(userOne.getDob().getAge() - userTwo.getDob().getAge());
        return String.format("The age difference between %s %s and %s %s is %d years.",
                userOne.getName().getFirst(), userOne.getName().getLast(),
                userTwo.getName().getFirst(), userTwo.getName().getLast(),
                ageDifference);
    }
}
