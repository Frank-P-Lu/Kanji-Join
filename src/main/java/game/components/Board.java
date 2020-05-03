package game.components;

import game.components.placeables.Blank;
import game.components.placeables.Placeable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
Essentially a chess board where radicals can be popped on.
Co-ordinates: [x, y]. These are zero indexed.
Eventually, these should be mouse driven.
 [
    [(1,1), (2,1)],
    [(1,2), (2,2)],
]
 */
public class Board {
    private final int numberColumns;
    private final int numberRows;
    private List<List<Placeable>> board;  // rows and columns


    public Board(int numberColumns, int numberRows) {
        this.numberColumns = numberColumns;
        this.numberRows = numberRows;
        initBoard();
    }

    private void initBoard(){
        this.board = new ArrayList<>(numberRows);  // number of columns
        IntStream.range(0, numberRows).forEach(row -> {
            ArrayList<Placeable> newRow = new ArrayList<>(numberColumns);
            IntStream.range(0, numberColumns).forEach(column ->
                    newRow.add(new Blank())
            );
            this.board.add(newRow);
        });

    }

    private Coordinate processCoordinates(int column, int row) throws InvalidCoordinateException{
        Coordinate coordinate = new Coordinate(column, row);
        if(!isValidCoordinate(coordinate)){
            throw new InvalidCoordinateException();
        }
        return coordinate;
    }

    private boolean isValidCoordinate(Coordinate coordinate) {
        return (coordinate.row < this.numberRows) && (coordinate.row > -1)
                && (coordinate.column < numberColumns) && (coordinate.column > -1) ;
    }


    public void addItem(int column, int row, Placeable item) throws InvalidCoordinateException {
        Coordinate coordinate = processCoordinates(column, row);
        this.board.get(coordinate.column).set(coordinate.row, item);
    }


    public Placeable getBoardItem(int column, int row) throws InvalidCoordinateException{
        Coordinate coordinate = processCoordinates(column, row);
        return this.board.get(coordinate.column).get(coordinate.row);
    }

    public List<List<Placeable>> getBoard() {
        return board;
    }

    public int getNumberColumns() {
        return numberColumns;
    }

    public int getNumberRows() {
        return numberRows;
    }

    static class Coordinate{
        private int column;
        private int row;

        private Coordinate(int column, int row) {
            this.column = column;
            this.row = row;
        }
    }
}

