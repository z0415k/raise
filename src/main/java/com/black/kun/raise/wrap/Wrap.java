package com.black.kun.raise.wrap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wrap {
    public static ThreadLocal<String> TIMESTAMP = new ThreadLocal<>();

    private int status;
    private String message;
    private Object data;
    private String timestamp;

    public String getTimestamp() {
        this.timestamp = TIMESTAMP.get();
        return timestamp;
    }
}
