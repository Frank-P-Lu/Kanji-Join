package game.components;

import game.components.kanji.Kanji;

import java.util.List;
import java.util.Map;

/*
Essentially a chess board where radicals can be popped on.
Co-ordinates: [x, y].
Eventually, these should be mouse driven.
 [
    [(1,1), (2,1)],
    [(1,2), (2,2)],
]
 */
public class Board {
    private int length;
    private int width;
    private Map<Integer, List<Kanji>> board;  // rows and columns


    public Board(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void addKanji(int insertX, int insertY, Kanji kanji){

    }



}
