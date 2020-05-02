package game.components;

import game.components.kanji.Kanji;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    protected Board board;

    @BeforeEach
    protected void setUp(){
        board = new Board(5, 5);
    }

    @Test
    public void shouldAddValidKanjiToBoard() throws InvalidCoordinateException {
        // given
        Kanji kanji = new Kanji();

        // when
        board.addKanji(3, 2, kanji);

        // then
        assertSame(board.get(2, 3), kanji);
    }
}