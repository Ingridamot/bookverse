package lt.codeacademy.bookverse.common.security.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;

import jakarta.servlet.*;
@Component
@Log4j2
public class BookverseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.trace("-----> my bookverse filter implementation :::before::: do filter chain. Any logic with servletRequest");

        filterChain.doFilter(servletRequest, servletResponse);

        log.trace("-----> my bookverse filter implementation :::after::: do filter chain. Any logic with servletResponse");
    }
}
