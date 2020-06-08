package hr.tvz.kerhin.studapp.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail printStudentsJobDetail(){
        return JobBuilder.newJob(PrintStudentsJob.class).withIdentity("printStudentsJob").storeDurably().build();
    }

    @Bean
    public Trigger printStudentsTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(printStudentsJobDetail())
                .withIdentity("printStudentsTrigger").withSchedule(scheduleBuilder).build();
    }
}
