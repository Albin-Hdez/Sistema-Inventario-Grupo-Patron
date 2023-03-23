package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

public class controller_mouse implements MouseListener
{
    static String ip2;
    static String suc;
    public void mouseClicked(MouseEvent e) 
    {
        if(e.getClickCount() == 1)
                {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int col = target.getSelectedColumn();
                    
                    ip2 = (String) target.getValueAt(row, col);
                    suc = (String) target.getValueAt(row, 2);
                    System.err.println(ip2+suc+" jala alv");
                }
    }
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
