package epam.advanced.practice6.startegy.cards;

import java.util.*;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>>  map = new TreeMap<>();
            List<Card> communityCards = new ArrayList<>();
            map.put("Community", communityCards);
            for (int i = 1; i <= players; i++) {
                map.put("Player " + i, new ArrayList<>());
            }

            for (int j = 0; j < 2; j++) {
                for (int i = 1; i <= players; i++) {
                    map.get("Player " + i).add(deck.dealCard());
                }
            }

            for (int i = 0; i < 5; i++) {
                communityCards.add(deck.dealCard());
            }
            map.put("Remaining", deck.restCards());
            return map;
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>>  map = new TreeMap<>();

            for (int i = 1; i <= players; i++) {
                map.put("Player " + i, new ArrayList<>());
            }

            for (int j = 0; j < 5; j++) {
                for (int i = 1; i <= players; i++) {
                    map.get("Player " + i).add(deck.dealCard());
                }
            }

            map.put("Remaining", deck.restCards());
            return map;
        };
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return (deck, players) -> {
            Map<String, List<Card>>  map = new TreeMap<>();

            for (int i = 1; i <= players; i++) {
                map.put("Player " + i, new ArrayList<>());
            }

            for (int j = 0; j < 13; j++) {
                for (int i = 1; i <= players; i++) {
                    map.get("Player " + i).add(deck.dealCard());
                }
            }

            return map;
        };
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return (deck, players) -> {
            Map<String, List<Card>>  map = new TreeMap<>();

            for (int i = 1; i <= players; i++) {
                map.put("Player " + i, new ArrayList<>());
            }

            for (int j = 0; j < 6; j++) {
                for (int i = 1; i <= players; i++) {
                    map.get("Player " + i).add(deck.dealCard());
                }
            }

            List<Card> trump = new ArrayList<>();
            trump.add(deck.dealCard());
            map.put("Remaining", deck.restCards());
            map.put("Trump card",trump);
            return map;
        };
    }

}
