package com.zc.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Locale;

public class LoderConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lan = request.getParameter("lan");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(lan)){
            String[] lans = lan.split("_");
            locale = new Locale(lans[0],lans[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
