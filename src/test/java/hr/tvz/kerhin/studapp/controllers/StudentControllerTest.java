package hr.tvz.kerhin.studapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllStudents() throws Exception {
        this.mockMvc
                .perform(get("/student").with(user("admin").password("123456")
                        .roles("USER", "ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getStudentsByJMBAG() throws Exception {
        this.mockMvc
                .perform(get("/student/1234567891").with(user("admin").password("123456")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        this.mockMvc
                .perform(get("/student/1234567893").with(user("admin").password("123456")))
                .andExpect(status().isNotFound());
    }

    @Test
    @DirtiesContext
    void addStudent() throws Exception {

        String TEST_JMBAG = "1234567892";
        String TEST_FIRST_NAME = "Lana";
        String TEST_LAST_NAME = "Fiček";

        String newStudentJson = "{\n" +
                "   \"firstName\": \"Lana\", \n" +
                "   \"lastName\": \"Fiček\", \n" +
                "   \"jmbag\": \"1234567892\", \n" +
                "   \"dateOfBirth\": \"1994-05-29\", \n" +
                "   \"numberOfECTS\": 100 \n" +
                "}";

        this.mockMvc
                .perform(post("/student").with(user("admin").password("123456")
                        .roles("ADMIN", "USER"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newStudentJson)
                        .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.jmbag").value(TEST_JMBAG))
                .andExpect(jsonPath("$.firstName").value(TEST_FIRST_NAME))
                .andExpect(jsonPath("$.lastName").value(TEST_LAST_NAME));


    }

    @Test
    @DirtiesContext
    public void delete() throws Exception{
        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/student/1234567891")
                    .with(user("admin").password("1234567")
                            .authorities(new SimpleGrantedAuthority("ROLE_ADMIN"))))
                .andExpect(status().isNoContent());
    }

    @Test
    @DirtiesContext
    public void update() throws Exception{

        String TEST_FIRST_NAME = "Lana";
        String TEST_LAST_NAME = "Fiček";

        String updateStudentJson = "{\n" +
                "   \"firstName\": \"Lana\", \n" +
                "   \"lastName\": \"Fiček\", \n" +
                "   \"jmbag\": \"1234567891\", \n" +
                "   \"dateOfBirth\": \"1994-05-29\", \n" +
                "   \"numberOfECTS\": 100 \n" +
                "}";

        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/student/1234567891")
                        .with(user("admin").password("123456")
                        .roles("ADMIN", "USER"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateStudentJson)
                        .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(TEST_FIRST_NAME))
                .andExpect(jsonPath("$.lastName").value(TEST_LAST_NAME));

    }

    @Test
    @DirtiesContext
    public void updateFail() throws Exception{

        String updateStudentJson = "{\n" +
                "   \"lastName\": \"Fiček\", \n" +
                "   \"jmbag\": \"1234567891\", \n" +
                "   \"dateOfBirth\": \"1994-05-29\", \n" +
                "   \"numberOfECTS\": 100 \n" +
                "}";

        this.mockMvc
                .perform(MockMvcRequestBuilders.put("/student/1234567891")
                        .with(user("admin").password("123456")
                                .roles("ADMIN", "USER"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateStudentJson)
                        .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isBadRequest());

    }
}