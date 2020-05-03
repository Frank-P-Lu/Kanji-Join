package game.components;

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