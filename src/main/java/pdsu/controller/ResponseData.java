package pdsu.controller;

/**
 * @auther yinxingye
 * @date 2020/5/20 15:49
 */
public class ResponseData {

    private String message;
    private int code;
    private  Object object;

    public ResponseData() {
    }

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", object=" + object +
                '}';
    }
    public static ResponseData ok() {
        return new ResponseData(200, "Ok");
    }

    public ResponseData(String message, int code, Object object) {
        this.message = message;
        this.code = code;
        this.object = object;
    }
    public ResponseData backSuccessData(Object value) {

        return new ResponseData("success",200,value);
    }
}
