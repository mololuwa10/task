package com.example.xtremepush.task.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.xtremepush.task.Model.User;

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

class UserResponse {
    private List<User> results;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}
