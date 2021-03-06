package com.vision.project.models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vision.project.models.Chat;
import com.vision.project.models.Message;
import com.vision.project.models.Session;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SessionDto {
    private LocalDate date;
    private List<MessageDto> messages;

    public SessionDto(LocalDate date, List<Message> messages) {
        this.date = date;
        this.messages = messages.stream().map(MessageDto::new).collect(Collectors.toList());
    }

    public SessionDto(Session session){
        this.date = session.getDate();
        this.messages = session.getMessages().stream().map(MessageDto::new).collect(Collectors.toList());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }
}
