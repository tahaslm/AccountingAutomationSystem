
public class EmailException extends Exception {
  public EmailException(){
       super("your email must be like this xyz@gmail.com (it can contain every character before @)"); 
}
}