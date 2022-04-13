package vn.com.huylq.springexample.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.com.huylq.springexample.service.LoggingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoggingServiceImpl implements LoggingService {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public void logRequest(HttpServletRequest request, Object payload) {
        StringBuilder logData = new StringBuilder();
        logData.append("\n----------REQUEST----------\n")
               .append("[URI]: ")
               .append(request.getMethod()).append(" ")
               .append(request.getRequestURI()).append("\n")
               .append("[PAYLOAD]: ")
               .append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload))
               .append("\n----------REQUEST----------\n");
        log.info(logData.toString());
    }

    @SneakyThrows
    @Override
    public void logResponse(@NonNull HttpServletResponse response, Object payload) {
        StringBuilder logData = new StringBuilder();
        logData.append("\n----------RESPONSE----------\n")
               .append("[STATUS]: ")
               .append(HttpStatus.valueOf(response.getStatus())).append("\n")
               .append("[PAYLOAD]: ")
               .append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload))
               .append("\n----------RESPONSE----------\n");
        log.info(logData.toString());
    }
}
