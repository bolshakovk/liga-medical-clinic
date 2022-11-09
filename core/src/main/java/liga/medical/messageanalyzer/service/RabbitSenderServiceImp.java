package liga.medical.messageanalyzer.service;

import api.RabbitSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.RabbitMessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitSenderServiceImp implements RabbitSenderService {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper o;
    public RabbitSenderServiceImp(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.o = objectMapper;
    }

    @Override
    public void sendMessage(RabbitMessageDto messageDTO, String str) throws JsonProcessingException {
        String messageStr = o.writeValueAsString(messageDTO);
        amqpTemplate.convertAndSend(str, messageStr);
        System.out.println(String.format("Сообщение [%s] в очередь [%s] отправлено c типом [%s]", messageStr, str, messageDTO.getType()));
    }

    @Override
    public void sendError(String s) {

    }
}
