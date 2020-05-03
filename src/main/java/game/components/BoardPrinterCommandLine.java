package game.components;

import game.components.kanji.Kanji;

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
        List<String> output = IntStream.range(0, board.getNumberRows())
            .mapToObj(rowNumber -> {
                    List<String> rowOutput = new ArrayList<>();
                    addRowIndicator(rowOutput, rowNumber);

                    IntStream.range(0, board.getNumberColumns()).forEach(columnNumber -> addRowContents(rowOutput, getKanji(columnNumber, rowNumber)));
                    return String.join("", rowOutput);
                }).collect(Collectors.toList());

        String outputJoined = String.join("\n", output);
        System.out.println(outputJoined);
    }

    private Kanji getKanji(int column, int row){
        try {
            return board.getKanji(column, row);

        } catch (InvalidCoordinateException e) {
            throw new RuntimeException("Invalid board state. Attempting to fetch from col:" + column + ", row:" + row);
        }
    }

    private void addRowIndicator(List<String> row, int rowNumber){
        row.add(rowNumber + "  |");
    }

    private void addRowContents(List<String> rowOutput, Kanji kanji) {
        rowOutput.add("  " + kanji.toString() + "  |");
    }
}
