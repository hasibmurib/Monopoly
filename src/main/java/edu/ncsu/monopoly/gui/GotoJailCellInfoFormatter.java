package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.CELL;

public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    public String format(CELL cell) {
    	return GOTO_JAIL_LABEL;
	}
}
