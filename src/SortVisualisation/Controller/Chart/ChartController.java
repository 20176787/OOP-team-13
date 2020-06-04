package SortVisualisation.Controller.Chart;

import SortVisualisation.Controller.AbstractSortController;
import javafx.application.Application;
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

public class ChartController  implements Initializable {
    int startRange = 100;
    int endRange   = 1000;
    int step       = 100;
    @FXML
    LineChart<String,Number> lineChart;
    @Override
    public void initialize(URL location, ResourceBundle resource){
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        XYChart.Data <String , Number> jan = new XYChart.Data<>("jan",300);
        series.getData().addAll(jan);
        series.setName("hello");
//       lineChart.getData().add(series);
    }
}
