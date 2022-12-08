package mvc.interceptor;

import constants.ConstAttributes;
import constants.ErrorMessages;
import exceptions.AccessForbiddenException;
import mvc.handler.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //logger.debug("LoginInterceptor caught "+request.getRequestURI());
        String uri = request.getRequestURI();
        if (uri.contains("login")) return true;
        if (uri.contains("admin")) {
            HttpSession session = request.getSession();
            Object admin = session.getAttribute(ConstAttributes.ATTR_LOGIN_ADMIN);
            if (admin == null) {
                throw new AccessForbiddenException(ErrorMessages.ACCESS_FORBIDDEN);
            }
        }
        return true;
    }
}
