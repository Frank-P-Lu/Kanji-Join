package game.components.board;

import game.components.placeables.Placeable;

import java.util.ArrayList;
import java.util.Collection;
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
        String output = IntStream.range(0, board.getNumberRows())
            .mapToObj(this::makeOutputRows)  // to List< List<String>>
            .flatMap(Collection::stream)  // flatten to List<String>
            .collect(Collectors.joining("\n"))
                + closingRows();
        System.out.println(output);
    }

    private List<String> makeOutputRows(int rowNumber) {
        List<String> rowOutput = new ArrayList<>();

        String separatorRow = makeSeparatorRow();
        rowOutput.add(separatorRow);

        String contentRow = makeContentRow(rowNumber);
        rowOutput.add(contentRow);

        return rowOutput;
    }

    private String makeSeparatorRow() {
        return repeat(ROW_AND_COLUMN_SPACING, " ") + "*" + repeat(board.getNumberColumns(), " - - *");

    }

    private String makeContentRow(int rowNumber){
        return makeRowIndicator(rowNumber) +
                IntStream.range(0, board.getNumberColumns())
                    .mapToObj(columnNumber -> getPlaceableContent(getItem(columnNumber, rowNumber)))
                    .collect(Collectors.joining());
    }

    private String makeRowIndicator(int rowNumber){
        return rowNumber + repeat(ROW_AND_COLUMN_SPACING - 1, " ") + "|";
    }

    private Placeable getItem(int column, int row){
        try {
            return board.getBoardItem(column, row);

        } catch (InvalidCoordinateException e) {
            throw new RuntimeException("Invalid board state. Attempting to fetch from col:" + column + ", row:" + row);
        }
    }

    private String getPlaceableContent(Placeable item) {
        return "  " + item.toString() + "  |";
    }

    private String closingRows() {
        return "\n" + makeSeparatorRow() + "\n" + makeColumnIndicator();
    }

    private String makeColumnIndicator() {
        return repeat(ROW_AND_COLUMN_SPACING + 1, " ") +
                IntStream.range(0, board.getNumberColumns())
                        .mapToObj(columnNumber -> "  " + columnNumber + "   ")
                        .collect(Collectors.joining());
    }


    private static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }
}
