package com.mobileapplication.controller;

import com.mobileapplication.service.impl.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping(path = "/loginForm")
    public String loginForm(Model model) {
        return "loginFormNew";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Principal user) throws ExceptionInInitializerError {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (user != null) {

            log.info("Got user info for login = " + user.getName());
            SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
            SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");

            if (user instanceof AbstractAuthenticationToken) {
                User userDetails = (User) ((AbstractAuthenticationToken) user).getPrincipal();
                loginService.loginByEmail(user.getName());
                if (userDetails.getAuthorities().contains(userAuthority)) {
                    return "redirect:/clientAccount/chooseContract";
                } else if (userDetails.getAuthorities().contains(adminAuthority)) {
                    return "redirect:/adminAccount";
                }
            }
        }
        return "redirect:/loginForm";
    }

    /**
     * Метод для выхода из приложения и сброса параметров аутентификации.
     *
     * @param rq Запрос
     * @param rs Ответ
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest rq, HttpServletResponse rs) {

        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(rq, rs, null);
        return "redirect:/loginForm";

    }


}

