package game.components;

import game.components.kanji.Kanji;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class ComponentsFixture {

    static final List<Kanji> kanjiList = Arrays.asList(
            new Kanji("漢"), new Kanji("字"), new Kanji("認"), new Kanji("識"));

    static final Random random = new Random();

    static Kanji generateRandomKanji(){
       return kanjiList.get(random.nextInt(kanjiList.size()));
    }

    static Board generateTestBoard(){
        Board board = new Board(5, 5);
        try {
            board.addKanji(random.nextInt(5) + 1,  random.nextInt(5) + 1, generateRandomKanji());
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }
        return board;
    }
}
