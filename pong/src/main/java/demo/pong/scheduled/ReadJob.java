package demo.pong.scheduled;

import demo.pong.service.DisruptorPongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class ReadJob {
    @Value("${filePath}")
    private String filePath;
    @Autowired
    private DisruptorPongService disruptorPongService;
    @Scheduled(cron = "*/1 * * * * ?")
    public void scheduler()  {
        disruptorPongService.processPongJob(filePath);
    }
}
