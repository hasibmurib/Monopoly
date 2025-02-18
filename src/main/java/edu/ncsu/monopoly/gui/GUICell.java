package edu.ncsu.monopoly.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.BevelBorder;

import edu.ncsu.monopoly.CELL;
import edu.ncsu.monopoly.GameMaster;

public class GUICell extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3697063853300632551L;
	private CELL cell;
	private JLabel lblInfo;
	private JLabel[] lblPlayers = new JLabel[GameMaster.MAX_PLAYER];
	
    public GUICell(CELL cell) {
    this.cell = cell;
    setLayout(new OverlayLayout(this));
    setBorder(new BevelBorder(BevelBorder.LOWERED));
    var pnlPlayer = new JPanel();
    pnlPlayer.setLayout(new GridLayout(2, 4));
    pnlPlayer.setOpaque(false);
    createPlayerLabels(pnlPlayer);
    add(pnlPlayer);
    setPreferredSize(new Dimension(100,100));
    addCellInfo();
    this.doLayout();
}
	
	private void addCellInfo() {
        lblInfo = new JLabel();
		displayInfo();
        var pnlInfo = new JPanel();
        pnlInfo.setLayout(new GridLayout(1, 1));
        pnlInfo.add(lblInfo);
        add(pnlInfo);
    }
	
	public void addPlayer(int index) {
		var player = GameMaster.instance().getPlayer(index);
		lblPlayers[index].setText(player.getName().substring(0, 1));
		lblPlayers[index].setOpaque(true);
	}

    private void createPlayerLabels(JPanel pnlPlayer) {
		for (var i = 0; i < GameMaster.MAX_PLAYER; i++) {
			lblPlayers[i] = new JLabel();
			lblPlayers[i].setBackground(Color.GREEN);
			pnlPlayer.add(lblPlayers[i]);
		}
	}

	public void displayInfo() {
		lblInfo.setText(InfoFormatter.cellInfo(cell));
    this.invalidate();
		this.repaint();
	}

	public CELL getCell() {
		return cell;
	}
	
	public void removePlayer(int index) {
		lblPlayers[index].setText("");
		lblPlayers[index].setOpaque(false);
        this.repaint();
	}
}
