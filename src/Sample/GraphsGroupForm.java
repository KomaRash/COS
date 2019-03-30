package Sample;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GraphsGroupForm extends VBox {

    public GraphsGroupForm(){
        GraphsGroup graph = new GraphsGroup(AlgorithmOp.getOriginalGraph(), "", "Original Graph");
        GraphsGroup graph1 = new GraphsGroup(AlgorithmOp.getFastFourierGraph(AlgorithmOp.getOriginalGraph()), "FFT", "");
        GraphsGroup graph2 = new GraphsGroup(AlgorithmOp.getPhaseCharacteristicsFFT(AlgorithmOp.getOriginalGraph()), "FFT", "Phase");
        GraphsGroup graph3 = new GraphsGroup(AlgorithmOp.getReverseFFT(AlgorithmOp.getOriginalGraph()), "FFT", "Phase");
        GraphsGroup graph4 = new GraphsGroup(AlgorithmOp.getDiscreteFourierGraph(AlgorithmOp.getOriginalGraph()), "FFT", "");
        GraphsGroup graph5 = new GraphsGroup(AlgorithmOp.getPhaseCharacteristicsDFT(AlgorithmOp.getOriginalGraph()), "FFT", "Phase");
        GraphsGroup graph6 = new GraphsGroup(AlgorithmOp.getReverseDFT(AlgorithmOp.getOriginalGraph()), "FFT", "Phase");


        HBox hBox1=new HBox();
        HBox hBox2=new HBox();
        hBox1.getChildren().addAll(graph1.getGraphsGroup(), graph2.getGraphsGroup(),graph3.getGraphsGroup());
        hBox2.getChildren().addAll(graph4.getGraphsGroup(),graph5.getGraphsGroup(),graph6.getGraphsGroup());
        getChildren().addAll(hBox1,hBox2,graph.getGraphsGroup());
    }
}