package Server;

import Utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCalcu {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanCalcu> history(){
        List<BeanCalcu> calc = new ArrayList<>();
        BeanCalcu calcu = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM operations");
            rs = pste.executeQuery();
            while(rs.next()){
                calcu.setId(rs.getLong("id"));
                calcu.setType(rs.getString("type"));
                calcu.setFnum(rs.getDouble("first_number"));
                calcu.setSnum(rs.getDouble("second_number"));
                calcu.setResult(rs.getDouble("result"));
                calcu.setCreated(rs.getDate("created_at"));
                calc.add(calcu);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalcu.class.getName()).log(Level.SEVERE, "Error", e);
        }finally{
            closeConnection();
        }
        return calc;
    }

    public boolean save(BeanCalcu calcu){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO operations (type, first_number, second_number, result, created_at) VALUES (?, ?, ?, ?, ?)");
            pste.setString(1, calcu.getType());
            pste.setDouble(2, calcu.getFnum());
            pste.setDouble(3, calcu.getSnum());
            pste.setDouble(4, calcu.getResult());
            pste.setDate(5, (Date) calcu.getCreated());
            //return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCalcu.class.getName()).log(Level.SEVERE, "Error", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pste != null){
                pste.close();
            }
            if(cstn != null){
                cstn.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e){

        }
    }
}
