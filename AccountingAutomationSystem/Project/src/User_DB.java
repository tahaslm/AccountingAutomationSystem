import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


//DBManager for adding user to databese
public class User_DB {
   static final String connectionString = "jdbc:mysql://localhost:3306/" + "workers?user=root&password=wilfSachZH014";
            


    static Connection conn = null;

    public static boolean InsertNewUser(User user) {
       
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers" , "root" , "wilfSachZH014");

            Statement stmt = conn.createStatement();
            String query = "INSERT INTO informations"
                    + "(name,surname,email,age,password)"
                    + "VALUES('" + user.name + "','" + user.surname+ "','" + user.email+ "','" 
                     + user.age + "','" + user.password + "')";
            stmt.executeUpdate(query);

            conn.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(User_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
        public static User SignIn(String email, String password)
    {   
        User ruser=null;
            try {
            conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM informations WHERE email='" + email + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                ruser = new User();
                
                ruser.name = rs.getString("name");
                ruser.surname = rs.getString("surname");
                ruser.email = rs.getString("email");
                ruser.age = rs.getInt("age");
                ruser.password = rs.getString("password");
              
            }
            conn.close();
        } catch (SQLException ex) {    
    
 System.out.println(" error:" + ex.getMessage());
        }
        
        
        return ruser;
    
    }
      
    }
