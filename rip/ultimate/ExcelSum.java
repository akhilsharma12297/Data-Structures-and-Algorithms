package rip.ultimate;

import java.util.*;

class Excel {
    private int height;
    private int width;
    private Map<String, Integer> values;
    private Map<String, List<String>> sumFormulas;

    public Excel(int H, char W) {
        height = H;
        width = W - 'A' + 1;
        values = new HashMap<>();
        sumFormulas = new HashMap<>();
    }

    public void set(int row, char column, int val) {
        String cell = String.format("%c%d", column, row);
        values.put(cell, val);
        sumFormulas.remove(cell);  // Reset any existing sum formulas for this cell
    }

    public int get(int row, char column) {
        String cell = String.format("%c%d", column, row);
        if (sumFormulas.containsKey(cell)) {
            int sum = 0;
            for (String reference : sumFormulas.get(cell)) {
                sum += evaluateReference(reference);
            }
            return sum;
        } else {
            return values.getOrDefault(cell, 0);
        }
    }

    public int sum(int row, char column, List<String> numbers) {
        String cell = String.format("%c%d", column, row);
        sumFormulas.put(cell, new ArrayList<>(numbers));
        return get(row, column);
    }

    private int evaluateReference(String reference) {
        if (reference.contains(":")) {
            String[] range = reference.split(":");
            String startCell = range[0];
            String endCell = range[1];
            int sum = 0;
            for (int i = getRow(startCell); i <= getRow(endCell); i++) {
                for (int j = getColumn(startCell); j <= getColumn(endCell); j++) {
                    sum += get(i, (char) ('A' + j));
                }
            }
            return sum;
        } else {
            return get(getRow(reference), getColumn(reference));
        }
    }

    private int getRow(String cell) {
        return Integer.parseInt(cell.substring(1));
    }

    private char getColumn(String cell) {
        return cell.charAt(0);
    }

    public void display() {
        System.out.println("Excel Sheet:");
        System.out.print("   ");
        for (char col = 'A'; col < 'A' + width; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < width; j++) {
                System.out.print(get(i + 1, (char) ('A' + j)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Create an Excel sheet with 3 rows and 'C' columns
        Excel excelSheet = new Excel(3, 'C');

        excelSheet.display();

        // Set value at C(1, "A") to 2
        excelSheet.set(1, 'A', 2);

        excelSheet.display();

        // Print the value at C(3, "C") after applying the sum formula
        System.out.println("Sum(3, \"C\", [\"A1\", \"A1:B2\"]): " + excelSheet.sum(3, 'C', Arrays.asList("A1", "A1:B2"))); // Output: 4

        excelSheet.display();

        // Set value at C(2, "B") to 2
        excelSheet.set(2, 'B', 2);

        excelSheet.display();

        // Print the value at C(3, "C") after modifying a referenced cell
        System.out.println("After setting B2 to 2: " + excelSheet.get(3, 'C')); // Output: 6

        excelSheet.display();
    }
}
