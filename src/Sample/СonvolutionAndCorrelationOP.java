package Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class СonvolutionAndCorrelationOP {
    private static ArrayList<Complex> list;
    private static int N = 64;
    public static HashMap<Double, Double> getOriginalGraphY() {
        HashMap<Double, Double> graphHash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graphHash.put(2 * i * Math.PI / N, Math.cos(3 * 2 * i * Math.PI / N));
        }
        return graphHash;
    }
    public static HashMap<Double, Double> getOriginalGraphZ() {
        HashMap<Double, Double> graphHash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graphHash.put(2 * i * Math.PI / N, Math.sin(2* 2 * i * Math.PI / N));
        }
        return graphHash;
    }
    public static HashMap<Double, Double>     getCorrelationGraph()
    {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(CorrAndConv$.MODULE$.Corr(AlgorithmOp.getComplexArray(getOriginalGraphY())
                ,AlgorithmOp.getComplexArray(getOriginalGraphZ()))));
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).re());
            System.out.println(i+"  "+fouirierList.get(i).toString());
        }
        return result;
    }
    public static HashMap<Double, Double>   getConvolutionGraph()
    {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(CorrAndConv$.MODULE$.Conv(AlgorithmOp.getComplexArray(getOriginalGraphY())
                ,AlgorithmOp.getComplexArray(getOriginalGraphZ()))));
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).re());
            System.out.println(i+"  "+fouirierList.get(i).toString());
        }
        return result;
    }

}
