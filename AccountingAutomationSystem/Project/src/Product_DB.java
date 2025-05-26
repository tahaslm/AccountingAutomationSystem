

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
 
public class Product_DB extends Product {
static final String connectionString = "jdbc:mysql://localhost:3306/"+ "workers?user=root&password=wilfSachZH014";
            


    static Connection conn = null;

    public static boolean InsertProduct(Product product) {
       
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers" , "root" , "wilfSachZH014");

            Statement s = conn.createStatement();
            String query = "INSERT INTO accounting"
                    + "(name,date,fileNumber,company,city,purchasePrice,salePrice)"
                    + "VALUES('" + product.name + "','" + product.date + "','" + product.fileNumber + "','" + product.company + "','" + product.city 
                    + "','" + product.purchasePrice + "','" + product.salePrice + "')";
            s.executeUpdate(query);

            conn.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(User_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
     public static boolean DeleteProduct(Product product){
     
        try{
   
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers" , "root" , "wilfSachZH014");
Statement s = conn.createStatement();
     String query="DELETE FROM accounting WHERE fileNumber=" + product.fileNumber;
    s.executeUpdate(query);
conn.close();
   return true;
}
   catch(Exception ex){
Logger.getLogger(User_DB.class.getName()).log(Level.SEVERE, null, ex);
   } 
        return false;
    }

             }

      
    





