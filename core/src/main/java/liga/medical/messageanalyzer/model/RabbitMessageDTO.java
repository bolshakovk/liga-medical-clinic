package liga.medical.messageanalyzer.model;

import lombok.Data;

@Data
public class RabbitMessageDTO {
    private MessageType type;
    private String content;
}
