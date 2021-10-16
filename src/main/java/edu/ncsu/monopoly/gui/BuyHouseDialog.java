
package edu.ncsu.monopoly.gui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.ncsu.monopoly.Player;



    public class BuyHouseDialog extends JDialog 
{
	/**
	 * 
	 */
	private static final int TRES = 3;
	private static final int DOS = 2;
	/**
	 * 
	 */

	private JComboBox<String> cboMonopoly; 
	private JComboBox<String> cboNumber;

	private Player player;

    public BuyHouseDialog(Player player) 
	{
		this.player = player;
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(BuyHouseDialog.TRES, DOS));
		c.add(new JLabel("Select monopoly"));
		c.add(buildMonopolyComboBox());
		c.add(new JLabel("Number of houses"));
		c.add(buildNumberComboBox());
		c.add(buildOKButton());
		c.add(buildCancelButton());
		c.doLayout();
		this.pack();
	}

	private JButton buildCancelButton() 
	{
		var btn = new JButton("Cancel");
		btn.addActionListener(e -> 
				cancelClicked());
		return btn;
	}

	private JComboBox<String> buildMonopolyComboBox() 
	{
		cboMonopoly = new JComboBox<>(player.getMonopolies());
		return cboMonopoly;
	}

	private JComboBox<String> buildNumberComboBox() 
	{
		JComboBox<String> jComboBox = new JComboBox<>();
		cboNumber = jComboBox;
		return cboNumber;
	}

	private JButton buildOKButton() 
	{
		var btn = new JButton("OK");
		btn.addActionListener(e -> 
				okClicked()
		);
		return btn;
	}

	private void cancelClicked() 
	{
		this.dispose();
	}

	private void okClicked() 
	{
		String monopoly = (String)cboMonopoly.getSelectedItem();
		int number = cboNumber.getSelectedIndex() + 1;
		player.purchaseHouse(monopoly, number);
		this.dispose();
	}
}
