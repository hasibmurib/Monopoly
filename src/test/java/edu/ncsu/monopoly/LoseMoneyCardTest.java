package edu.ncsu.monopoly;

import junit.framework.TestCase;

public class LoseMoneyCardTest extends TestCase {
    GameMaster gameMaster;
    CARD loseMoneyCard;

    protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCLoseMoney());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		loseMoneyCard = new MoneyCard("Pay 20 dollars", -20, CARD.TYPE_CC);
		gameMaster.getGameBoard().addCard(loseMoneyCard);
    }
    
    public void testLoseMoneyCardAction() {
        int origMoney = gameMaster.getCurrentPlayer().getMoney();
		CARD card = gameMaster.drawCCCard();
		assertEquals(loseMoneyCard, card);
		card.applyAction();
		assertEquals(origMoney - 20, gameMaster.getCurrentPlayer().getMoney());
    }
    
    public void testLoseMoneyCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}
