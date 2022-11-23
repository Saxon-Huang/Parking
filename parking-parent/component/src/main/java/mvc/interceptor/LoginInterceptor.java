package mvc.interceptor;

import constants.ConstAttributes;
import constants.ErrorMessages;
import exceptions.AccessForbiddenException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object admin = session.getAttribute(ConstAttributes.ATTR_LOGIN_ADMIN);
        if (admin == null) {
            throw new AccessForbiddenException(ErrorMessages.ACCESS_FORBIDDEN);
        }
        return true;
    }
}
