package matrixmanipulations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MatrixManipulations {
    public double[][] elements;
    public MatrixManipulations(int n){
        elements = new double[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                elements[i][j] = n * random.nextDouble() * 2 - 1;
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder("");
        int maxValueLength = Integer.toString(elements.length).length()+4;
        for(int i = 0; i < elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                String formattedDouble = String.format("%.2f", elements[i][j]);
                buffer.append(formattedDouble);
                if(j != elements.length - 1){
                    buffer.append(" ".repeat(maxValueLength - formattedDouble.length() + 1));
                } else{
                    buffer.append("\n");
                }
            }
        }
        
        return buffer.toString();
    }
    
    public void task1(){
        for(int i = 0; i < elements.length; i++){
            double sum = 0;
            for(int j = 0; j < elements.length; j++){
                sum += elements[i][j];
            }
            double mean = sum / elements.length;
            for(int j = 0; j < elements.length; j++){
                elements[i][j] -= mean;
            }
        }
    }
    
    public void task2(){
        double max = Double.MIN_VALUE;
        for(int i = 0; i < elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                if(elements[i][j] > max){
                    max = elements[i][j];
                }
            }
        }
        ArrayList<Integer> maxCols = new ArrayList<Integer>();
        ArrayList<Integer> maxRows = new ArrayList<Integer>();
        for(int i = 0; i < elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                if(Math.abs(elements[i][j] - max) < 0.001){
                    maxCols.add(j);
                    maxRows.add(i);
                }
            }
        }
        int newN = elements.length - maxCols.size();
        double[][] newElements = new double[newN][newN];
        int newI = 0;
        int newJ = 0;

        for(int i = 0; i < elements.length; i++){
            if(!maxRows.contains(i)){
                for(int j = 0; j < elements.length; j++){
                    if(!maxCols.contains(j)){
                        newElements[newI][newJ] = elements[i][j];
                        newJ++;
                    }
                }
                newJ = 0;
                newI ++;
            }
        }
        elements = newElements;
    }
    
    public void task3(){
        ArrayList<Integer> zeroRows = new ArrayList<>();
        ArrayList<Integer> zeroColumns = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            boolean isZeroRow = true;
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] != 0) {
                    isZeroRow = false;
                    break;
                }
            }
            if (isZeroRow) {
                zeroRows.add(i);
            }
        }

        for (int j = 0; j < elements[0].length; j++) {
            boolean isZeroColumn = true;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i][j] != 0) {
                    isZeroColumn = false;
                    break;
                }
            }
            if (isZeroColumn) {
                zeroColumns.add(j);
            }
        }
        
        int newN = elements.length - zeroColumns.size();
        double[][] newElements = new double[newN][newN];
        int newI = 0;
        int newJ = 0;
        
        for(int i = 0; i < elements.length; i++){
            if(!zeroRows.contains(i)){
                for(int j = 0; j < elements.length; j++){
                    if(!zeroColumns.contains(j)){
                        newElements[newI][newJ] = elements[i][j];
                        newJ++;
                    }
                }
                newJ = 0;
                newI ++;
            }
        }
        elements = newElements;
    }
    
    public void task4(int targetRow, int targetCol) {
        if (targetRow < 0 || targetRow >= elements.length || targetCol < 0 || targetCol >= elements[0].length) {
            System.out.println("Invalid target position.");
            return;
        }

        double minValue = Double.MAX_VALUE;
        int minRow = -1;
        int minCol = -1;

        // Find the minimum element and its position
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] < minValue) {
                    minValue = elements[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        // Swap the row containing the minimum element with the target row
        double[] tempRow = elements[minRow];
        elements[minRow] = elements[targetRow];
        elements[targetRow] = tempRow;

        // Swap the column containing the minimum element with the target column
        for (int i = 0; i < elements.length; i++) {
            double temp = elements[i][minCol];
            elements[i][minCol] = elements[i][targetCol];
            elements[i][targetCol] = temp;
        }
    }
    
    public int task5(){
        int saddlePointCount = 0;
        for (int i = 0; i < elements.length; i++) {
            double minInRow = Double.POSITIVE_INFINITY;
            int minInRowJ = 0;
            for (int j = 0; j < elements[i].length; j++) {
                if(elements[i][j] < minInRow){
                    minInRow = elements[i][j];
                    minInRowJ = j;
                }
            }
            double maxInColumn = Double.NEGATIVE_INFINITY;
            for(int k = 0; k < elements.length; k++){
                if(elements[k][minInRowJ] > maxInColumn){
                    maxInColumn = elements[k][minInRowJ];
                }
            }
            if (Math.abs(minInRow - maxInColumn) < 0.001){
                saddlePointCount++;
            }
        }
        return saddlePointCount;
    }
    
    public void task6(){
        HashMap<Double, ArrayList<Integer>> sums = new HashMap<Double, ArrayList<Integer>>();
        for (int i = 0; i < elements.length; i++) {
            double sum = 0;
            for (int j = 0; j < elements[i].length; j++) {
                sum += elements[i][j];
            }
            if(sums.containsKey(sum)){
                sums.get(sum).add(i);
            } else{
                sums.put(sum, new ArrayList<Integer>());
                sums.get(sum).add(i);
            }
        }
        double[][] newElements = new double[elements.length][elements.length];
        TreeSet<Double> keySet = new TreeSet(sums.keySet());
        int i = 0;
        for(Double maximum: keySet){
            for(int row: sums.get(maximum)){
                newElements[i] = elements[row];
                i++;
            }
        }
        elements = newElements;
    }
    
    public int task7() {
        int localMinimumCount = 0;

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                boolean isLocalMinimum = true;

                if (i > 0 && elements[i][j] >= elements[i - 1][j]) {
                    isLocalMinimum = false;
                }
                if (i < elements.length - 1 && elements[i][j] >= elements[i + 1][j]) {
                    isLocalMinimum = false;
                }

                if (j > 0 && elements[i][j] >= elements[i][j - 1]) {
                    isLocalMinimum = false;
                }
                if (j < elements[i].length - 1 && elements[i][j] >= elements[i][j + 1]) {
                    isLocalMinimum = false;
                }

                if (i > 0 && j > 0 && elements[i][j] >= elements[i - 1][j - 1]) {
                    isLocalMinimum = false;
                }
                if (i < elements.length - 1 && j > 0 && elements[i][j] >= elements[i + 1][j - 1]) {
                    isLocalMinimum = false;
                }
                if (i > 0 && j < elements[i].length - 1 && elements[i][j] >= elements[i - 1][j + 1]) {
                    isLocalMinimum = false;
                }
                if (i < elements.length - 1 && j < elements[i].length - 1 && elements[i][j] >= elements[i + 1][j + 1]) {
                    isLocalMinimum = false;
                }

                if (isLocalMinimum) {
                    localMinimumCount++;
                }
            }
        }
        return localMinimumCount;
    }
    
    public double task8(){
        ArrayList<Double> maximums = new ArrayList<Double>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                boolean isLocalMaximum = true;

                if (i > 0 && elements[i][j] <= elements[i - 1][j]) {
                    isLocalMaximum = false;
                }
                if (i < elements.length - 1 && elements[i][j] <= elements[i + 1][j]) {
                    isLocalMaximum = false;
                }

                if (j > 0 && elements[i][j] <= elements[i][j - 1]) {
                    isLocalMaximum = false;
                }
                if (j < elements[i].length - 1 && elements[i][j] <= elements[i][j + 1]) {
                    isLocalMaximum = false;
                }

                if (i > 0 && j > 0 && elements[i][j] <= elements[i - 1][j - 1]) {
                    isLocalMaximum = false;
                }
                if (i < elements.length - 1 && j > 0 && elements[i][j] <= elements[i + 1][j - 1]) {
                    isLocalMaximum = false;
                }
                if (i > 0 && j < elements[i].length - 1 && elements[i][j] <= elements[i - 1][j + 1]) {
                    isLocalMaximum = false;
                }
                if (i < elements.length - 1 && j < elements[i].length - 1 && elements[i][j] <= elements[i + 1][j + 1]) {
                    isLocalMaximum = false;
                }

                if (isLocalMaximum) {
                    maximums.add(elements[i][j]);
                }
            }
        }
        return Collections.min(maximums);
    }
    
    public void task9(){
        HashMap<Double, ArrayList<Integer>> characteristics = new HashMap<Double, ArrayList<Integer>>();
        for (int i = 0; i < elements.length; i++) {
            double sum = 0;
            for (int j = 0; j < elements[i].length; j++) {
                sum += Math.abs(elements[j][i]);
            }
            if(characteristics.containsKey(sum)){
                characteristics.get(sum).add(i);
            } else{
                characteristics.put(sum, new ArrayList<Integer>());
                characteristics.get(sum).add(i);
            }
        }
        double[][] newElements = new double[elements.length][elements.length];
        ArrayList<Double> keyList = new ArrayList<Double>(characteristics.keySet());
        Collections.reverse(keyList);
        int j = 0;
        for(Double characteristic: keyList){
            for(int column: characteristics.get(characteristic)){
                for(int i = 0; i < elements.length; i++){
                    newElements[i][j] = elements[i][column];
                }
                j++;
            }
        }
        elements = newElements;
    }
}
