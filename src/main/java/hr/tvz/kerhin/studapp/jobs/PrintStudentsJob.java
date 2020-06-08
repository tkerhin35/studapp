package hr.tvz.kerhin.studapp.jobs;

import java.util.List;
import hr.tvz.kerhin.studapp.models.DTO.StudentDTO;
import hr.tvz.kerhin.studapp.services.implementatios.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@AllArgsConstructor
public class PrintStudentsJob  extends QuartzJobBean {

    private final StudentServiceImpl service;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<StudentDTO> students = service.findAll();

        System.out.println("Ovo su trenutno upisani studenti:");
        System.out.println("---------------------------------");
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getJmbag() + " - " + students.get(i).getFirstName()
                + " " + students.get(i).getLastName());
        }
        System.out.println("---------------------------------");

    }
}
