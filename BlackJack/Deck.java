package Z_OOD.BlackJack;
import java.util.*;

public class Deck {

    private final List<Card> cards = new ArrayList<>();     // or Card[] array
    private int dealIndex = 0;
    private static final Random ran = new Random();

    // constructor
    public Deck() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {               // 将从1 --> 13的牌，每一号都赋予4种花色
                cards.add(new Card(i, suit));
            }
        }
    }

    // public API
    public Card dealCard() {                                // 发单张牌
        return remainingCards() == 0 ? null : cards.get(dealIndex++);
    }

    public Card[] dealHand(int number) {                    // 发多张牌
        // corner case
        if (remainingCards() < number) {                    // 如果剩余牌量 < 想发的牌量，返回null
            return null;
        }

        Card[] cards = new Card[number];
        for (int i = 0; i < number; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }

    private int remainingCards() {                          // 返回当前Deck剩余牌量
        return cards.size() - dealIndex;
    }


    public void shuffle() {
        for (int i = 0; i < cards.size() - 1; i++) {        // i < cards.size() - 1 因为我们每次要拿两张random牌交换
                                                            // 所以要留下一至少张牌来作为随机交换的"第二张牌"
            int j = ran.nextInt(cards.size() - i) + i;

            Card card1 = cards.get(i);                      // 如果是i < cards.size()，那么很可能出现两张一模一样的牌交换
            Card card2 = cards.get(j);

            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public void reset() {
        dealIndex = 0;
        shuffle();
    }
}
