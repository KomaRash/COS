package Sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;

public class GraphsGroup {
    private LineChart<Number, Number> graph;
    private NumberAxis Yaxis, Xaxis;
    private XYChart.Series series;
    private ObservableList<XYChart.Data> data;
    public GraphsGroup(HashMap<Double, Double> graphHash, String title, String seriesName){
        Yaxis = new NumberAxis();
        Xaxis = new NumberAxis();
        graph = new LineChart<>(Xaxis, Yaxis);
        graph.setTitle(title);
        graph.setCreateSymbols(false);
        series = new XYChart.Series();
        series.setName(seriesName);
        data = FXCollections.observableArrayList();
        for (Object o : graphHash.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            data.add(new XYChart.Data(pair.getKey(), pair.getValue()));
        }
        series.setData(data);
        graph.getData().add(series);
    }
    public LineChart<Number, Number> getGraphsGroup(){
        return graph;
    }
}
