package exception;

import org.apache.commons.lang3.ArrayUtils;

public class MyBizException extends Exception {

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
    }

    public MyBizException(String message, Throwable e) {
        super(message, e);
    }


    public void setErrorcode() {

    }

}
