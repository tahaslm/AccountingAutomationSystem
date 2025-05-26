
public class PasswordException extends Exception{
   public PasswordException(){
       super("your password must be at least 8 characters and "
               + "contain at least one uppercase letter, one lowercase letter and a number");
   } 
}
