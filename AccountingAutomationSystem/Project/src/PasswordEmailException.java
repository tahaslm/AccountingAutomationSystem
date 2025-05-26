
public class PasswordEmailException extends Exception{
    public PasswordEmailException(){
       super("your password must be at least 8 characters and "
               + "contain at least one uppercase letter, one lowercase letter "
               + "and a number and your email must be like this xyz@gmail.com (it can contain every character before @)");
   } 

}
