package day5;

import java.util.List;
import java.util.stream.Collectors;

public class SeatFinder {

    public Seat findSeat(String binarySpacePartitioning) {
        String rowPartition = binarySpacePartitioning.substring(0, 7);
        String columnPartition = binarySpacePartitioning.substring(7);

        rowPartition = rowPartition.replace("B", "1");
        rowPartition = rowPartition.replace("F", "0");
        columnPartition = columnPartition.replace("R", "1");
        columnPartition = columnPartition.replace("L", "0");

        int row = Integer.parseInt(rowPartition, 2);
        int column = Integer.parseInt(columnPartition, 2);

        return new Seat(row, column);
    }
}
