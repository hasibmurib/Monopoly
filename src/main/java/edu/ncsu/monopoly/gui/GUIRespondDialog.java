package edu.ncsu.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.ncsu.monopoly.RespondDialog;
import edu.ncsu.monopoly.TradeDeal;


public class GUIRespondDialog extends JDialog implements RespondDialog {
    private boolean response;
    JTextArea txtMessage = new JTextArea();
    
    public GUIRespondDialog() {
        JButton btnYes = new JButton("Yes");
        JButton btnNo = new JButton("No");
        txtMessage.setPreferredSize(new Dimension(300, 200));
        txtMessage.setEditable(false);
        txtMessage.setLineWrap(true);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(txtMessage, BorderLayout.CENTER);
        JPanel pnlButtons = new JPanel();
        pnlButtons.add(btnYes);
        pnlButtons.add(btnNo);
        contentPane.add(pnlButtons, BorderLayout.SOUTH);
        
        btnYes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                response = true;
                hide();
            }
        });

        btnNo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                response = false;
                hide();
            }
        });
    
        setModal(true);
        pack();
    }

    public boolean getResponse() {
        return response;
    }
    
    public void setDeal(TradeDeal deal) {
        txtMessage.setText(deal.makeMessage());
    }

}
