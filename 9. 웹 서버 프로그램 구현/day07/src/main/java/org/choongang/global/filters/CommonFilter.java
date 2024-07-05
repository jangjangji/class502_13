package org.choongang.global.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//인터페이스에서 default 메서드는 기능에대한 선언만 가능했지만 내부에 포함된 메서드 정의
@WebFilter("/*")
public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new CommonRequestWrapper(request),response);

    }
}
