package game.components;

import game.components.kanji.Kanji;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    protected Board board;

    @BeforeEach
    protected void setUp() {
        board = new Board(5, 5);
    }

    @Test
    public void shouldAddValidKanjiToBoard() throws InvalidCoordinateException {
        // given
        Kanji kanji = new Kanji();

        // when
        board.addKanji(3, 2, kanji);

        // then
        assertSame(board.getKanji(3, 2), kanji);
    }

    @Test
    public void shouldThrowInvalidCoordinateExceptionWhenInvalidCoordinate() {
        // given
        int[] invalidCols = {0, 6, 1};
        int[] invalidRows = {0, 5, -1};
        List<Exception> exceptions = new ArrayList<>();

        // when
        IntStream.range(0, 3).forEach(i -> exceptions.add(
                assertThrows(InvalidCoordinateException.class,
                        () -> board.getKanji(invalidCols[i], invalidRows[i]))));

        // then
        exceptions.forEach(Assertions::assertNotNull);
    }

}