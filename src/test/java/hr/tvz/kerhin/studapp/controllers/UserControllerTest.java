package hr.tvz.kerhin.studapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCurrentUser() throws Exception {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbmlzdHJhdG9yIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE1OTA1OTA1NTd9.CYz2M8Lh3LikJT8rBvih4awzg9_9TfdwMyMkOkGcQ2d-qloOz7fTHE_sHtlc4iqpP7b9JLq9zv3JRvQSJxa6Tw");

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/user/current-user"))
                .andExpect(status().isNotFound());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/user/current-user")
                    .headers(httpHeaders))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}