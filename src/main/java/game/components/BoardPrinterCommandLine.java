package game.components;

import game.components.placeables.Kanji;
import game.components.placeables.Placeable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardPrinterCommandLine implements BoardPrinter{
    Board board;

    private final int ROW_AND_COLUMN_SPACING = 3;

    public BoardPrinterCommandLine(Board board) {
        this.board = board;
    }

    @Override
    public void printBoard() {
        // The output of the board with format [ ["Row1 string"], ["Row2 string"]
        // This is so we can format each row seperately
        String output = IntStream.range(0, board.getNumberRows())
            .mapToObj(rowNumber -> {
                    List<String> rowOutput = new ArrayList<>();
                    addRowIndicator(rowOutput, rowNumber);

                    IntStream.range(0, board.getNumberColumns())
                            .forEach(columnNumber -> addRowContents(rowOutput, getItem(columnNumber, rowNumber)));
                    return String.join("", rowOutput);
                })
                .collect(Collectors.joining("\n"));

        System.out.println(output);
    }

    private Placeable getItem(int column, int row){
        try {
            return board.getBoardItem(column, row);

        } catch (InvalidCoordinateException e) {
            throw new RuntimeException("Invalid board state. Attempting to fetch from col:" + column + ", row:" + row);
        }
    }

    private void addRowIndicator(List<String> row, int rowNumber){
        row.add(rowNumber + "  |");
    }

    private void addRowContents(List<String> rowOutput, Placeable item) {
        rowOutput.add("  " + item.toString() + "  |");
    }
}
