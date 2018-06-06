package com.black.kun.raise.wrap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice(basePackages = {"com.black.kun.raise.controller.demo"})
public class GlobalResponseWrapper implements ResponseBodyAdvice {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Wrap wrap = new Wrap(200, "success", o, null);
        if (o instanceof String) {
            try {
                return objectMapper.writeValueAsString(wrap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return wrap;
    }
}
