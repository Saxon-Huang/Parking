package utility;

import javax.servlet.http.HttpServletRequest;

public class RequestIdentify {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String acceptHead = request.getHeader("accept");
        String xRequestHead = request.getHeader("X-Requested-With");
        return (acceptHead != null && acceptHead.contains("application/json")) || (xRequestHead != null && xRequestHead.equals("XMLHttpRequest"));
    }
}
