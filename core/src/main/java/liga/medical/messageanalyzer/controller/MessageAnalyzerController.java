package liga.medical.messageanalyzer.controller;

import api.RabbitSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import model.RabbitMessageDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static config.RabbitConfig.ROUTER_QUEUE_NAME;

@RestController
@RequestMapping("/rabbit")

public class MessageAnalyzerController {

    private final RabbitSenderService rabbitSenderService;

    public MessageAnalyzerController(RabbitSenderService rabbitSenderService) {
        this.rabbitSenderService = rabbitSenderService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody RabbitMessageDto messageDTO) throws JsonProcessingException{
        rabbitSenderService.sendMessage(messageDTO, ROUTER_QUEUE_NAME);
    }
}
