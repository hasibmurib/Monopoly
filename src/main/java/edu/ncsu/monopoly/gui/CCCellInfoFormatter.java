package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.CELL;

public class CCCellInfoFormatter implements CellInfoFormatter {
    public String format(CELL cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
