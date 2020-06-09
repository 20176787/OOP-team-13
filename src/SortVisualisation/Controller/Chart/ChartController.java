package SortVisualisation.Controller.Chart;

import SortVisualisation.Controller.AbstractSortController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.*;

public class ChartController extends AbstractSortController  implements Initializable {
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resource){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("length of array");
        yAxis.setLabel("Time (in milliseconds)");
        LineChart.setTitle("Sort Algorithm Comparison");
        addingDataToChart(LineChart);
    }
    public void addingDataToChart(LineChart<String, Number> lineChart) {
        // declare series
        XYChart.Series quickSort = new XYChart.Series();
        quickSort.setName("Quick Sort");
        XYChart.Series heapSort = new XYChart.Series();
        heapSort.setName("Heap Sort");
        XYChart.Series radixSort = new XYChart.Series();
        radixSort.setName("Radix Sort");
        XYChart.Series bubbleSort = new XYChart.Series();
        bubbleSort.setName("Bubble Sort");
        for (int i = startRange; i <= endRange; i += step) {
            // Create an array with numbers 0 to n
            ArrayList<Integer> nums = new ArrayList<>(i);
            for (int j = 1; j <= i; j++)
                nums.add(j);
            // shuffle the nums array
            Collections.shuffle(nums);
            // copy nums ArrayList to normal array for using in sort algorithms
            int[] mainNums = new int[endRange];
            for (int j = 0; j < nums.size(); j++)
                mainNums[j] = nums.get(j);
            // make a copy of mainNums array to emulate same condition for every sort algorithm
            int[] sortArr;
            long first, second;
            System.out.format("Sorting: %d numbers\n", i);
            // sort algorithms
            // Quick Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            QuickSort.sort(sortArr, 0, i - 1);
            second = System.currentTimeMillis();
            quickSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));
            // Heap Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            HeapSort.sort(sortArr);
            second = System.currentTimeMillis();
            heapSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));
            // Radix Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            RadixSort.sort(sortArr);
            second = System.currentTimeMillis();
            radixSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));
            // Bubble Sort
//            sortArr = mainNums.clone();
//            first = System.currentTimeMillis();
//            BubbleSort.sort(sortArr);
//            second = System.currentTimeMillis();
//            bubbleSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

        }

        // adding series to line chart
        lineChart.getData().addAll(quickSort, radixSort, heapSort,bubbleSort);

    }
}
