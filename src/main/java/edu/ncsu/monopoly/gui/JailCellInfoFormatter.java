package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.CELL;

public class JailCellInfoFormatter implements CellInfoFormatter {

    public static final String JAIL_CELL_LABEL = "<html><b>Jail</b></html>";

    public String format(CELL cell) {
		return JAIL_CELL_LABEL;
	}

}
