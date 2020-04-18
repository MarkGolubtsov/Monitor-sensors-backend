package com.labinvent.task.web.security;


import com.labinvent.task.serivice.UserService;
import com.labinvent.task.serivice.dto.UserDTO;
import com.labinvent.task.serivice.exception.NotFoundEntityException;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.domain.JWTException;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@Component
public class VerifyTokenFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyTokenFilter.class);
    private final UserService userService;

    public VerifyTokenFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(header) && header.startsWith(JwtProperties.TOKEN_PREFIX)) {

            String jwtToken = header.substring(JwtProperties.TOKEN_PREFIX.length());
            Verifier verifier = HMACVerifier.newVerifier(JwtProperties.SECRET);
            try {
                JWT jwt = JWT.getDecoder().decode(jwtToken, verifier);
                String email = jwt.getString("sub");
                UserDTO user = null;
                try {
                    user = userService.findByEmail(email);
                    UserAuthentication userAuthentication = new UserAuthentication(true, user,
                            Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));

                    SecurityContextHolder.getContext().setAuthentication(userAuthentication);
                } catch (NotFoundEntityException ignored) {
                    LOGGER.error("USER not in db");
                }
            } catch (JWTException ignored) {
                LOGGER.error("Bad token");
            }
        }
        chain.doFilter(request, response);
    }
}
