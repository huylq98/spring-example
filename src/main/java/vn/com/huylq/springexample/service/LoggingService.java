package vn.com.huylq.springexample.service;

import lombok.NonNull;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoggingService {
    void logRequest(@NonNull HttpServletRequest request, @Nullable Object payload);

    void logResponse(@NonNull HttpServletResponse response, @Nullable Object payload);
}
