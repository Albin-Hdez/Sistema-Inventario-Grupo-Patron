package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import model.model;
import view.principal;
import view.inventario;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JTable;
public class controller extends controller_mouse implements ActionListener, ItemListener
{   
    JFrame frame;
    JTable TablaP;
    static inventario i;
    model m;
    private ArrayList datos2 = new ArrayList<>();
    
    public controller()
    {
        
    }
    public controller(JFrame frame_c, JTable tabla)
    {
        frame=frame_c;
        TablaP=tabla;
    }
    public void Principal()
    {
        principal p = new principal();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	p.setExtendedState(JFrame.MAXIMIZED_BOTH);
	p.setResizable(true);
	p.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
    {
        String evento = e.getActionCommand();
        
        //VISTAS
        if(evento.equals("GESTION DE INVENTARIO"))
        {   
            m = new model();
            i = new inventario(frame, "GESTION DE INVENTARIO",m.select(m.conexion(), null));
            setDatos2(datos2);
            i.setSize(1000, 600);
            i.setBackground(Color.red);
            i.setResizable(false);
            i.setVisible(true);
        }
        
        if(evento.equals("filtrar"))
        {
            m = new model();
            String [] filters = i.filtros();
            datos2 = m.select(m.conexion(), filters);
            i.recargar(datos2);
            
        }
        if(evento.equals("refresh"))
        {
           m = new model();
           datos2 = m.select(m.conexion(), null);
           i.recargar(datos2);
        }
        if(evento.equals("ping"))
        {
            m = new model();
            String fila = ip2;
            m.ping(fila);
        }
        if(evento.equals("conectar"))
        {
            m = new model();
            String fila = ip2;
            String sucursal = suc;
            System.err.println(ip2+suc+"este");
            m.conectar(fila, sucursal);   
        }
        if(evento.equals("salir"))
        {
           i.cerrar();
        }
    }

    public ArrayList getDatos2() {
        return datos2;
    }

    public void setDatos2(ArrayList datos2) {
        this.datos2 = datos2;
    }

    public void itemStateChanged(ItemEvent e) 
    {
        i.createcb_features();
    }
    
}
