package com.cardgames.poker.fivecardpoker;

import com.cardgames.cards.Card;
import com.cardgames.poker.shared.Hand;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;


public class FiveCardPokerHand implements Hand {

    private final FiveCardHandAnalyzer handAnalyzer;

    private static final int POKER_HAND_SIZE = 5;

    FiveCardPokerHand(final Builder builder) {
        this.handAnalyzer = new FiveCardHandAnalyzer(builder.cards);
    }

    public FiveCardHandAnalyzer getHandAnalyzer() {
        return this.handAnalyzer;
    }

    @Override
    public String toString() {
        return this.getHandAnalyzer().getCards().toString();
    }

    public static class Builder {

        private SortedSet<Card> cards;

        public Builder() {
            this.cards = new TreeSet<>();
        }

        //You can Add Optional card into the builder 
        public Builder addCard(final Optional<Card> card) {
            this.cards.add(card.orElseThrow(IllegalStateException::new));
            return this;
        }
        //Check the size of our hand and make sure it is 5 
        //If no 5 in our hand we throw run time exception 
        public FiveCardPokerHand build() {
            if (this.cards.size() != POKER_HAND_SIZE) {
                throw new RuntimeException("Invalid hand size for hand " + this.cards.toString());
            }
            return new FiveCardPokerHand(this);
        }

    }
}
