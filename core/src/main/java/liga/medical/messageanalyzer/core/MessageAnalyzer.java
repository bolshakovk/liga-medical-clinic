package liga.medical.messageanalyzer.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//TODO здесь сидит туду "liga.medical.common.service"
@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.messageanalyzer"})
public class MessageAnalyzer {
    public static void main(String[] args) {
        SpringApplication.run(MessageAnalyzer.class, args);
    }
}
