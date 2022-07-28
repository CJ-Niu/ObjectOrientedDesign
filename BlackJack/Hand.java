package Z_OOD.BlackJack;
import java.util.*;

public class Hand {

    protected final List<Card> cards = new ArrayList<>();

    public int score() {
        int score = 0;

        for (Card c : cards) {
            score += c.value();
        }
        return score;
    }

    public void addSingleCard(Card c) {             // 玩家拿到多张牌
        cards.add(c);
    }

    public void addMultipleCards(Card[] c) {        // 玩家拿到多张牌
        Collections.addAll(cards, c);               // Collections.addAll不会清空之前list里面的内容
    }

    public int size() {
        return cards.size();
    }
}
