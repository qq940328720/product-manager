package exception;

import com.hc.mvc.core.exception.base.BaseException;
import org.apache.commons.lang3.ArrayUtils;

public class MyBizException extends BaseException {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    public MyBizException(String message) {
        super(message);
    }

    public MyBizException(String message, Object... objects) {
        super(message);
        if (!ArrayUtils.isEmpty(objects)) {
            message = String.format(message, objects);
        }
        this.message = message;
    }

    public MyBizException(String message, Throwable e) {
        super(message, e);
    }


    @Override
    public void setErrorcode() {
        this.errorcode = "RULE_BIZ_EXCEPTION";
    }

}
