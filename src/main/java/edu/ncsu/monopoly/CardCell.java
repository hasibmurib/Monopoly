package edu.ncsu.monopoly;

public class CardCell extends CELL {
    private int type;
    
    public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }
    
    public void playAction() throws UnsupportedOperationException {
    }
    
    public int getType() {
        return type;
    }
}
