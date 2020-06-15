package game.components;

import game.components.board.Board;
import game.components.board.BoardPrinterCommandLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BoardPrinterCommandLineTest {

    Board board;
    BoardPrinterCommandLine printer;

    @BeforeEach
    void setUp() {
        board = ComponentsFixture.generateTestBoard();
        printer = new BoardPrinterCommandLine(board);
    }

    @Test
    public void printTestBoard(){
        printer.printBoard();
    }
}