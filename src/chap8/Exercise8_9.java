package chap8;

public class Exercise8_9 {
	public static void main(String[] args) throws Exception{
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다.",100);
	}
}

class UnsupportedFunctionException extends RuntimeException{
	final private int ERR_CODE;
	String message;
	UnsupportedFunctionException(String message, int ERR_CODE) {
		// TODO Auto-generated constructor stub
		super(message);//this.message = message;
		this.ERR_CODE = ERR_CODE;
	}
	UnsupportedFunctionException(String message){
		this(message,100);
	}
	public int getErrorCode(){
		return ERR_CODE;
	}
	public String getMessage(){
		return "["+ERR_CODE+"]"+super.getMessage();
	}
}