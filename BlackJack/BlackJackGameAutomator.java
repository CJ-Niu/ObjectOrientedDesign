package Z_OOD.BlackJack;
import java.util.*;

public class BlackJackGameAutomator {

    private Deck deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNTIL = 16;

    // constructor
    public BlackJackGameAutomator(int numOfPlayers) {
        hands = new BlackJackHand[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    void initializeDeck() {                             // 初始化Deck
        deck = new Deck();
        deck.shuffle();
    }

    boolean dealInitial() {                             // 开局：每人发两张牌
        for (BlackJackHand hand : hands) {
            Card[] cards = deck.dealHand(2);
            if (cards == null) {
                return false;
            }
            hand.addMultipleCards(cards);
        }
        return true;
    }

    List<Integer> getBlackJacks() {                     // 判断是否有人初始手牌直接获胜
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }

    boolean playHand(BlackJackHand hand) {              // 摸牌
        while (hand.score() < HIT_UNTIL) {
            Card c = deck.dealCard();
            if (c == null) {
                return false;
            }
            hand.addSingleCard(c);
        }
        return true;
    }

    boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> getWinners() {                        // 判断是否有人获胜
        List<Integer> winners = new ArrayList<>();
        int winningScore = 0;

        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();

                    winners.clear();
                    winners.add(i);
                } else if (hand.score() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.println("Hand " + i + " (" + hands[i].score() + "): ");
            //hands[i].print();
            System.out.println();
        }
    }

    public void simulate() {
        initializeDeck();

        boolean success = dealInitial();
        if (!success) {
            System.out.println("Error. Out of Cards.");
            return;
        }

        System.out.println("-- Initial --");
        printHandsAndScore();

        List<Integer> blackJacks = getBlackJacks();
        if (blackJacks.size() > 0) {
            System.out.println("Black Jack at: ");
            for (int i : blackJacks) {
                System.out.println(i + " ");
            }
            System.out.println("done.");
            return;
        }

        success = playAllHands();
        if (!success) {
            System.out.println("Error. Out of Cards.");
            return;
        }

        System.out.println("\n-- Completed Game --");
        printHandsAndScore();

        List<Integer> winners = getWinners();
        if (winners.size() > 0) {
            System.out.println("Winners: ");
            for (int i : winners) {
                System.out.println(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("Draw. All players have busted.");
        }
    }

    // Simple test case
    public static void main(String[] args) {
        BlackJackGameAutomator automator = new BlackJackGameAutomator(5);
        automator.simulate();
    }
}
