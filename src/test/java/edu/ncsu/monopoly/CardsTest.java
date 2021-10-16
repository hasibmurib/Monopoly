package edu.ncsu.monopoly;

import junit.framework.TestCase;

public class CardsTest extends TestCase {
    CARD ccCard, chanceCard;   
    
    GameMaster gameMaster;

    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        ccCard = new MoneyCard("Get 50 dollars", 50, CARD.TYPE_CC);
        chanceCard = new MoneyCard("Lose 50 dollars", -50, CARD.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(ccCard);
    }
    
    public void testCardType() {
        CARD card = gameMaster.drawCCCard();
        assertEquals(CARD.TYPE_CC, ccCard.getCardType());
        card = gameMaster.drawChanceCard();
        assertEquals(CARD.TYPE_CHANCE, chanceCard.getCardType());
    }
}
