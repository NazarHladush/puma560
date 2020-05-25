package com.ua.lviv.iot.puma560.jwt;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class CookieProvider {
    private int EXPIRED_TIME_FOR_COOKIE = 90000000;

    public Cookie createCookie(String key, String token) {
        Cookie cookie = new Cookie(key, token);
        cookie.setMaxAge(EXPIRED_TIME_FOR_COOKIE);
        cookie.setPath("/");
        return cookie;
    }


    public String readCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key))
                    token = c.getValue();
            }
        }
        return token;
    }

    public Cookie deleteCookie(String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        return cookie;
    }
}
