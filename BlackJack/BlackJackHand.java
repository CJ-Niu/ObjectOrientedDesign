package Z_OOD.BlackJack;
import java.util.*;

public class BlackJackHand extends Hand {
    @Override
    public int score() {
        List<Integer> scores = possibleScore();

        int maxScoreUnder21 = Integer.MIN_VALUE;
        int minScoreOver21 = Integer.MAX_VALUE;

        for (int s : scores) {
            if (s > 21 && s < minScoreOver21) {
                minScoreOver21 = s;
            } else if (s <= 21 && s > maxScoreUnder21) {
                maxScoreUnder21 = s;
            }
        }
        return maxScoreUnder21 == Integer.MIN_VALUE ? minScoreOver21 : maxScoreUnder21;
    }

    private List<Integer> possibleScore() {
        List<Integer> scores = new ArrayList<>();

        for (Card c : cards) {
            updateScores(c, scores);
        }
        return scores;
    }

    private void updateScores(Card c, List<Integer> scores) {
        final int[] toAdd = getScores(c);                   // 需要加上的牌面，因为有特殊情况1的存在，所以必须是array

        if (scores.isEmpty()) {                             // 之前的scores list为空，直接添加
            for (int s : toAdd) {
                scores.add(s);
            }
        } else {                                            //
            final int length = scores.size();

            for (int i = 0; i < length; i++) {              // scores之前存的是玩家手牌的所有可能的分数组合

                int oldScore = scores.get(i);               // 第一步：将现有的所有possible score + 新加入的"第一种可能"的牌面分数，
                scores.set(i, oldScore + toAdd[0]);         //        比如{1, 11}，这里就将所有之前的老分都 + 1

                for (int j = 1; j < toAdd.length; j++) {    // 第二部：将现有的所有possible score + 新加入的"第二种可能"分
                    scores.add(oldScore + toAdd[j]);        //         比如{1, 11}，这里就将所有之前的老分都 + 11
                }                                           //         再将新计算出新的possible score加到score list里面
            }
        }
    }

    private int[] getScores(Card c) {                       // 如果牌面 > 1 && 牌面 < 10，返回牌面
        if (c.value() > 1) {                                // 如果牌面 > 1 && 牌面 >= 10，返回10
            return new int[] {Math.min(c.value(), 10)};
        } else {                                            // 如果牌面 == 1，返回1和11
            return new int[] {1, 11};                       // 因为BlackJack里面1既能代表1，也能代表11
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card first = cards.get(0);
        Card second = cards.get(1);

        return (isAce(first) && isFaceCard(second)) || (isAce(second) && isFaceCard(first));
    }

    private boolean isAce(Card c) {
        return c.value() == 1;
    }

    private boolean isFaceCard(Card c) {
        return c.value() >= 11 && c.value() <= 13;
    }
}
