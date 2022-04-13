package vn.com.huylq.springexample.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.com.huylq.springexample.service.LoggingService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomURLFilter implements Filter {

    private final LoggingService loggingService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getContentLength() == -1)
            loggingService.logRequest((HttpServletRequest) request, null);
        chain.doFilter(request, response);
    }
}
