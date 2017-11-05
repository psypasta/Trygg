package gui.sales;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class SalesPanel extends JPanel implements ActionListener {
	
	
	private InventoryPanel inventory = new InventoryPanel();
	private ReportPanel report = new ReportPanel();
	
	private CardLayout layout = new CardLayout();
	private JPanel panel = new JPanel(layout);

	/**
	 * Create the panel.
	 */
	public SalesPanel() {
        setLayout(null);
        JLabel label = new JLabel("Sales");
        label.setBounds(257, 11, 25, 14);
        add(label);
        
        JList list = new JList();
        list.setBounds(406, 23, 161, 333);
        add(list);
        
    //    JPanel panel = new JPanel();
   //     panel.setBounds(10, 23, 389, 299);
  //      add(panel);
        
        JButton btnNewButton = new JButton("Rapport");
        btnNewButton.setBounds(307, 333, 89, 23);
        add(btnNewButton);
        
        JButton btnLager = new JButton("Lager");
        btnLager.setBounds(212, 333, 89, 23);
        add(btnLager);
        
        btnNewButton.addActionListener(this);
        btnLager.addActionListener(this);
     //   panel.setLayout(null);
        
     //   inventory.setBounds(191, 5, 1, 1);
        //   report.setBounds(197, 5, 1, 1);
        panel.setBounds(10, 39, 389, 280);
        add(panel);
        
        
        panel.add(inventory, "inventory");
   
        panel.add(report, "report");
	}
  
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
        if ("Lager".equals(command)) {
        	System.out.println("lager");
            layout.show(panel, "inventory");
        } else if ("Rapport".equals(command)) {
        	System.out.println("rapport");
            layout.show(panel, "report");
        } 
		
	}
}
