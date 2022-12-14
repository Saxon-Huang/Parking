package mvc.config;

import com.google.gson.Gson;
import constants.ConstAttributes;
import constants.ConstPages;
import exceptions.AccessForbiddenException;
import exceptions.AddAdminException;
import exceptions.LoginFailedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import utility.RequestIdentify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = ConstPages.ERROR_PAGE;
        return helperResolver(viewName, exception, request, response);
    }

    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolveLoginFailed(LoginFailedException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = ConstPages.ADMIN_LOGIN_PAGE;
        return helperResolver(viewName, exception, request, response);
    }

    @ExceptionHandler(value = AccessForbiddenException.class)
    public ModelAndView resolveAccessForbidden(LoginFailedException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = ConstPages.ADMIN_LOGIN_PAGE;
        return helperResolver(viewName, exception, request, response);
    }

    @ExceptionHandler(value = AddAdminException.class)
    public ModelAndView resolveAddAdmin(AddAdminException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = ConstPages.ADMIN_MAIN;
        return helperResolver(viewName, exception, request, response);
    }


    private ModelAndView helperResolver(String viewName, Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (RequestIdentify.isAjaxRequest(request)) {
            Gson gson = new Gson();
            String message = gson.toJson(exception.getMessage());
            response.getWriter().write(message);
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ConstAttributes.ATTR_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
