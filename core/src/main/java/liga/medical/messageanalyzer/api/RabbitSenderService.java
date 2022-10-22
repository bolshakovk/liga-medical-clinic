package liga.medical.messageanalyzer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.messageanalyzer.model.RabbitMessageDTO;

public interface RabbitSenderService {
    void sendMessage(RabbitMessageDTO messageDTO, String str) throws JsonProcessingException;
}
