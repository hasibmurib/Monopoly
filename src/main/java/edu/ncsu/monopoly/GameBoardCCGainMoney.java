package edu.ncsu.monopoly;


public class GameBoardCCGainMoney extends GameBoard {
    public GameBoardCCGainMoney() {
		super();
		PropertyCell blue1 = new PropertyCell();
		PropertyCell blue2 = new PropertyCell();
		CardCell cc1 = new CardCell(CARD.TYPE_CC, "Community Chest 1");
		JailCell jail = new JailCell();
		CardCell chance1 = new CardCell(CARD.TYPE_CHANCE, "Chance 1");
		
		CARD ccCard1 = new MoneyCard("Win $50", 50, CARD.TYPE_CC);
        CARD chanceCard1 = new MoneyCard("Win $30", 30, CARD.TYPE_CHANCE);
		
		blue1.setName("Blue 1");
		blue2.setName("Blue 2");
		
		blue1.setColorGroup("blue");
		blue2.setColorGroup("blue");
		
		blue1.setPrice(100);
		blue2.setPrice(100);
		
		blue1.setRent(10);
		blue2.setRent(10);
		
		blue1.setHousePrice(50);
		blue2.setHousePrice(50);
		
		addCard(ccCard1);
        addCard(chanceCard1);
		
		addCell(cc1);
		addCell(blue1);
		addCell(jail);
		addCell(blue2);
		addCell(chance1);
		
    }
}
