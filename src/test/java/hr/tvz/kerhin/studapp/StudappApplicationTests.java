package hr.tvz.kerhin.studapp;

import static org.assertj.core.api.Assertions.assertThat;

import hr.tvz.kerhin.studapp.controllers.CourseController;
import hr.tvz.kerhin.studapp.controllers.StudentController;
import hr.tvz.kerhin.studapp.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudappApplicationTests {

    @Autowired
    private StudentController studentController;

    @Autowired
    private CourseController courseController;

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        assertThat(studentController).isNotNull();
        assertThat(courseController).isNotNull();
        assertThat(userController).isNotNull();
    }

}
