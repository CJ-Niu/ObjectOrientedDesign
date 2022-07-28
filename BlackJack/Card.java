package Z_OOD.BlackJack;
import java.util.*;

public class Card {

    private final int faceValue;        // 1 --> A, 11 --> J, 12 --> Q, 13 --> K
    // private final FaceValue v;       // faceValue也可以使用enum class，这里使用int是因为好计算点数，没有好坏，不同选择
    private final Suit suit;

    // constructor
    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    // Public API
    public int value() {
        return faceValue;
    }

    public Suit suit() {
        return suit;
    }
}

