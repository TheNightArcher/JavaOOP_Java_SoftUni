package cardsWithPower_03;

public class Card {
    private SuitPower suitPower;
    private RankPower rankPower;

    public Card(SuitPower suitPower, RankPower rankPower) {
        this.suitPower = suitPower;
        this.rankPower = rankPower;
    }

    public int getPower(){
       return suitPower.getSuitPower() + rankPower.getPowerRank();
    }
}
