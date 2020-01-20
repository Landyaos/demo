package com.utopia.demo.component;


import cn.hutool.json.JSONUtil;
import com.sun.xml.fastinfoset.CommonResourceBundle;
import com.utopia.demo.common.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.unAuthorized(e.getMessage())));
        httpServletResponse.getWriter().flush();

    }
}
