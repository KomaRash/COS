package Sample;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GraphsGroupForm extends VBox {

    public GraphsGroupForm(){
        GraphsGroup graph = new GraphsGroup(СonvolutionAndCorrelationOP.getOriginalGraphY(), "cos(3x)", "Original Graph Y");
        GraphsGroup graph1 = new GraphsGroup(СonvolutionAndCorrelationOP.getOriginalGraphZ(), "sin(2x)", "Original Graph Z");
        GraphsGroup graph2 = new GraphsGroup(СonvolutionAndCorrelationOP.getConvolutionGraph(), "Свертка", "Свертка");
        GraphsGroup graph3 = new GraphsGroup(СonvolutionAndCorrelationOP.getCorrelationGraph(), "корреляция", "корреляция");

        HBox hBox1=new HBox();
        HBox hBox2=new HBox();
        hBox1.getChildren().addAll(graph.getGraphsGroup(), graph2.getGraphsGroup());
        hBox2.getChildren().addAll(graph1.getGraphsGroup(),graph3.getGraphsGroup());
        getChildren().addAll(hBox1,hBox2);
    }
}