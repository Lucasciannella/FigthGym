package fightclub.com.academia.exceptions;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private int status;
    private String developerMessage;
    private LocalDateTime timestamp;
    private String details;
}