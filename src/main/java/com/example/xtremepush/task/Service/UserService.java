package com.example.xtremepush.task.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.xtremepush.task.Model.User;
import com.example.xtremepush.task.Model.UserResponse;

@Service
public class UserService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://randomuser.me/api/?seed=%s";

    @SuppressWarnings("null")
    public User getUser(String seed) {
        String url = String.format(API_URL, seed);
        return restTemplate.getForObject(url, UserResponse.class).getResults().get(0);
    }
}
