package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class model 
{
     public Connection conexion()
    {
       Connection conn = null;
        try 
        {
            conn =  DriverManager.getConnection("jdbc:mysql://localhost/grupopatron?user=root&password=");
        } catch (SQLException ex) 
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
     public ArrayList<equipo> select(Connection conn)
     {
        //Connection conn = conexion();
        ArrayList <equipo> datos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        
        String SELECT = "SELECT * FROM inventario";
        
         try 
         {
             stmt = conn.createStatement();
             rs = stmt.executeQuery(SELECT);
             while(rs.next())
            {
                String IP = rs.getString(1);
                String ENCARGADO = rs.getString(2);
                String SUCURSAL = rs.getString(3);
                String PROCESADOR = rs.getString(4);
                String RAM = rs.getString(5);
                String TDD = rs.getString(6);
                String CAPACIDAD = rs.getString(7);
                String STATUS = rs.getString(8);

                equipo pc = new equipo();

                pc.setIP(IP);
                pc.setENCARGADO(ENCARGADO);
                pc.setSUCURSAL(SUCURSAL);
                pc.setPROCESADOR(PROCESADOR);
                pc.setRAM(Integer.parseInt(RAM));
                pc.setTDD(TDD);
                pc.setCAPACIDAD(Integer.parseInt(CAPACIDAD));
                pc.setSTATUS(Integer.parseInt(STATUS));

                //System.out.println(pc);
                datos.add(pc);
            }
            rs.close();
            stmt.close();
            conn.close();
         } catch (SQLException ex) 
         {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
         }
         return datos;
     }
    public void ping(String ip)
    {
            
        try {
                String comando = "ping "+ip;
                Runtime tiempoEjecucion = Runtime.getRuntime();
                Process proceso = tiempoEjecucion.exec("cmd.exe /C " + comando);

                InputStream is = proceso.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
		
                String linea;
                String msg = "";
                    while ((linea = br.readLine()) != null) 
                    {
                        System.out.println(linea);
                        msg = msg+'\n'+linea;
                    }
                 br.close();
                 JOptionPane.showMessageDialog(null, msg,"PING:"+ip,JOptionPane.INFORMATION_MESSAGE);
            }catch (IOException ex){ex.printStackTrace();}
     }
     public void conectar(String ip, String sucursal)
     {
         //System.out.println(ip+""+sucursal);
         //tvnviewer.exe -host=192.168.0.10 -password=mercado
        try
        {
            String comando = "tvnviewer.exe -host="+ip+" -password="+sucursal.toLowerCase();
            Runtime tiempoEjecucion = Runtime.getRuntime();
            Process proceso = tiempoEjecucion.exec("cmd.exe /C" + comando, null, new File("C:\\Program Files\\TightVNC"));
        }catch(IOException ex){ex.printStackTrace();}

     }
}
