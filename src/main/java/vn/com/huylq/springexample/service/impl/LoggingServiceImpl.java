package vn.com.huylq.springexample.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import vn.com.huylq.springexample.service.LoggingService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoggingServiceImpl implements LoggingService {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public void logRequest(@NonNull HttpServletRequest request, Object payload) {
        StringBuilder logData = new StringBuilder();
        logData.append("----------REQUEST----------\n")
               .append("[URI]: ")
               .append(request.getMethod()).append(" ")
               .append(request.getRequestURI()).append("\n")
               .append("[PAYLOAD]: ")
               .append(objectMapper.writeValueAsString(payload)).append("\n")
               .append("----------REQUEST----------\n");
        log.info(logData.toString());
    }

    @SneakyThrows
    @Override
    public void logResponse(@NonNull HttpServletResponse response, Object payload) {
        StringBuilder logData = new StringBuilder();
        logData.append("----------RESPONSE----------\n")
               .append("[STATUS]: ")
               .append(HttpStatus.valueOf(response.getStatus())).append("\n")
               .append("[PAYLOAD]: ")
               .append(objectMapper.writeValueAsString(payload)).append("\n")
               .append("----------RESPONSE----------\n");
        log.info(logData.toString());
    }
}
