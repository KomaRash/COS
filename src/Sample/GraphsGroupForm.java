package Sample;

import javafx.scene.layout.VBox;

public class GraphsGroupForm extends VBox {

    public GraphsGroupForm(){
        GraphsGroup graph = new GraphsGroup(AlgorithmOp.getOriginalGraph(), "cos(x)+sin(x)", "Original Graph");
        GraphsGroup graph1 = new GraphsGroup(AlgorithmOp.getFastFourierGraph(AlgorithmOp.getOriginalGraph()), "", "FFT");


        GraphsGroup graph2 = new GraphsGroup(AlgorithmOp.getDiscreteFourierGraph(AlgorithmOp.getOriginalGraph()), "", "DFT");
        GraphsGroup graph3 = new GraphsGroup(AlgorithmOp.getDiscreteFourierGraph(AlgorithmOp.getPhaseCharacteristics(AlgorithmOp.getOriginalGraph())), "", "Phase");
        GraphsGroup graph4 = new GraphsGroup(AlgorithmOp.getDiscreteFourierGraph(AlgorithmOp.getRE(AlgorithmOp.getOriginalGraph())), "", "Re");


        getChildren().addAll(graph.getGraphsGroup(),graph1.getGraphsGroup(), graph3.getGraphsGroup(), graph4.getGraphsGroup(), graph2.getGraphsGroup());
    }
}