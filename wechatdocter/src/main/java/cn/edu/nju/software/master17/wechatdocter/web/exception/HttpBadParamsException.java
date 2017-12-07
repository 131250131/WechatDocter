package cn.edu.nju.software.master17.wechatdocter.web.exception;

/**
 *
 * @author csc
 * @date 2017/12/8
 */
public class HttpBadParamsException extends RuntimeException{
    public HttpBadParamsException(String message) {
        super(message);
    }
}
