package util;

public class APIResult {
    private int code;
    private String message;
    private Object data;

    private static final int OK=200;
    private static final int NG=401;

    public static APIResult createOk(String message,Object data){
        return createWithCodeAndData(OK,message,data);
    }

    public static APIResult createOKMessage(String message){
        APIResult result =new APIResult();
        result.setCode(OK);
        result.setMessage(message);
        return result;
    }

    public static APIResult createNg(String message){
        return createWithCodeAndData(NG,message,null);
    }

    private static APIResult createWithCodeAndData(int code,String message,Object data){
        APIResult result=new APIResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
