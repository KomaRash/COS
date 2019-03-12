package Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AlgorithmOp {
    private static ArrayList<Complex> list;
    private static int N = 64;

    public static HashMap<Double, Double> getOriginalGraph(){
        HashMap<Double, Double> graphHash = new HashMap<>();
        for(int i=0; i<N; i++){
            graphHash.put(2 * i * Math.PI/N, Math.cos(2 * i * Math.PI/N)+Math.sin(2 * i * Math.PI/N));
        }
        return graphHash;
    }
    public  static HashMap<Double, Double> getFastFourierGraph(HashMap<Double, Double> source)
    {
        ArrayList<Complex> temp = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        for(int i=0; i<N; i++){
            temp.add(new Complex(source.get(2 * i * Math.PI/N), 0.0));
        }
        //fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier.FastFourier$.MODULE$.FFF(temp.toArray(new Complex[N]),N)));
        fouirierList=FourierJava.fastFourierTime(temp,N,-1);
        list = fouirierList;
        for(int i=0; i<N; i++){
            result.put(2 * Math.PI / N * i, fouirierList.get(i).mod());
        }
        return result;
    }
    public static HashMap<Double, Double> getDiscreteFourierGraph(HashMap<Double, Double> source){
        ArrayList<Complex> temp = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        for(int i=0; i<N; i++){
            temp.add(new Complex(source.get(2 * i * Math.PI/N), 0.0));
        }
        fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier.DiscreteFourier$.MODULE$.discreteFourier(temp.toArray(new Complex[N]))));
        //fouirierList=FourierJava.discreteFourier(temp,N,-1);
       list = fouirierList;
        for(int i=0; i<N; i++){
            result.put(2 * Math.PI / N * i, fouirierList.get(i).mod());
        }
        return result;
    }
    public static HashMap<Double, Double> getPhaseCharacteristics(HashMap<Double, Double> source){
        ArrayList<Complex> temp = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        for(int i=0; i<N; i++){
            temp.add(new Complex(source.get(2 * i * Math.PI/N), 0.0));
        }
        //fouirierList = new ArrayList<Complex>(Arrays.asList(Fourier.DiscreteFourier$.MODULE$.discreteFourier(temp.toArray(new Complex[N]))));
        fouirierList=FourierJava.discreteFourier(temp,N,-1);
        list = fouirierList;
        for(int i=0; i<N; i++){
            result.put(2 * Math.PI / N * i, fouirierList.get(i).phase());
        }
        return result;
    }

    public static HashMap<Double,Double> getRE(HashMap<Double,Double> source) {
        ArrayList<Complex> temp = new ArrayList<>();
        HashMap<Double, Double> result = new HashMap<>();
        ArrayList<Complex> fouirierList = null;
        for(int i=0; i<N; i++){
            temp.add(new Complex(source.get(2 * i * Math.PI/N), 0.0));
        }
        fouirierList=FourierJava.discreteFourier(temp,N,-1);
        list = fouirierList;
        for(int i=0; i<N; i++){
            result.put(2 * Math.PI / N * i, fouirierList.get(i).re());
        }
        return result;
    }
}
