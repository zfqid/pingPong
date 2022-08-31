package demo.ping.scheduled;

import demo.ping.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class WriteJob {
    @Value("${filePath}")
    private String filePath;
    @Autowired
    PingService pingService;
    @Scheduled(cron = "*/1 * * * * ?")
    public void scheduler()  {
        pingService.writeFile(filePath);
    }
}
