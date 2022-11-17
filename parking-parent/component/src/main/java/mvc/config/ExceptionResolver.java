package mvc.config;

import com.google.gson.Gson;
import constants.ConstAttributes;
import org.springframework.stereotype.Controller;
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
        if (RequestIdentify.isAjaxRequest(request)) {
            Gson gson = new Gson();
            String message = gson.toJson(exception.getMessage());
            response.getWriter().write(message);
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ConstAttributes.ATTR_EXCEPTION, exception);
        modelAndView.setViewName("system-error");
        return modelAndView;
    }
}
