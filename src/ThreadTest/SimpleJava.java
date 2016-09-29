package ThreadTest;

public class SimpleJava {

	class Animal{
		String name;
		public void bark(){
			System.out.println(name+" can bark!");
		}
	}
	
	class Dog extends Animal implements Run{
		Dog(String name){
			this.name=name;
		}
		
		public void run(){
			System.out.println(name+" can run!");
		}
	}
	
	interface Run{
		public void run();
	}
	
	
	
	class MyException extends Exception{
		String message;
		public MyException(String ErrorMessage){
			message=ErrorMessage;
		}
		
		public String getMessage(){
			return message;
		}
	}
	
	
	public static void pop() throws NegativeArraySizeException{
		int[] arr=new int[-3];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			e.toString();
		}
	}

}
