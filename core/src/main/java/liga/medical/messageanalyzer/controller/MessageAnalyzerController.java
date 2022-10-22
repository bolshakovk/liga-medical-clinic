package liga.medical.messageanalyzer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.messageanalyzer.api.RabbitSenderService;
import liga.medical.messageanalyzer.config.Config;
import liga.medical.messageanalyzer.model.RabbitMessageDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")

public class MessageAnalyzerController {

    private final RabbitSenderService rabbitSenderService;

    public MessageAnalyzerController(RabbitSenderService rabbitSenderService) {
        this.rabbitSenderService = rabbitSenderService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody RabbitMessageDTO messageDTO) throws JsonProcessingException{
        rabbitSenderService.sendMessage(messageDTO, Config.ROUTER_QUEUE_NAME);
    }
}
