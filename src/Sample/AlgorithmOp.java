package Sample;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AlgorithmOp {
    private static ArrayList<Complex> list;
    private static int N = 8;

    public static HashMap<Double, Double> getOriginalGraph() {
        HashMap<Double, Double> graphHash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graphHash.put(2 * i * Math.PI / N, Math.cos(3.00001* 2 * i * Math.PI / N) + Math.sin(2.0 * 2 * i * Math.PI / N));
        }
        return graphHash;
    }

    public static HashMap<Double, Double> getFastFourierGraph(HashMap<Double, Double> source) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier$.MODULE$.fastFourierTime(getComplexArray(source))));
        //fouirierList=FourierJava.fastFourierTime(temp,N,-1);
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).mod()/N);
        }
        return result;
    }

    public static HashMap<Double, Double> getDiscreteFourierGraph(HashMap<Double, Double> source) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier$.MODULE$.discreteFourier(getComplexArray(source))));
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).mod());
        }
        return result;
    }

    public static HashMap<Double, Double> getPhaseCharacteristicsDFT(HashMap<Double, Double> source) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier$.MODULE$.discreteFourier(getComplexArray(source))));
        //fouirierList = FourierJava.discreteFourier(temp, N, -1);
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).phase());
            System.out.println(i+"  "+fouirierList.get(i).toString());
        }
        return result;
    }

@NotNull
public static Complex[] getComplexArray(HashMap<Double, Double> source){
       ArrayList<Complex> temp = new ArrayList<>();
    for (int i = 0; i < N; i++) {
            temp.add(new Complex(source.get(2 * i * Math.PI / N), 0.0));
        }
    return     temp.toArray(new Complex[N]);
}
    public static HashMap<Double, Double> getPhaseCharacteristicsFFT(HashMap<Double, Double> source) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier$.MODULE$.fastFourierTime(getComplexArray(source))));
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).phase());
            System.out.println(i+"  "+fouirierList.get(i).toString());
        }
        return result;
    }


    public static HashMap<Double, Double> getReverseFFT(HashMap<Double, Double> source) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier$.MODULE$.reverseFourierFFT(getComplexArray(source))));
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).re());
        }
        return result;


    }

    public static HashMap<Double, Double> getReverseDFT(HashMap<Double, Double> source) {
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier$.MODULE$.reverseFourierDFT(getComplexArray(source))));
        list = fouirierList;
        for (int i = 0; i < N; i++) {
            result.put(2 * Math.PI / N * i, fouirierList.get(i).re());
        }
        return result;


    }
}

