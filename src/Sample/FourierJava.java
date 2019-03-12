package Sample;

import Sample.Complex;

import java.util.ArrayList;

public class FourierJava {


        public static ArrayList<Complex> discreteFourier(ArrayList<Complex> a, int N, int dir){
            ArrayList<Complex> result = new ArrayList<>();
            for(int k=0; k<N; k++){
                Complex temp = new Complex(0.0, 0.0);
                for(int n=0; n<N; n++){
                    temp = temp.$plus(a.get(n).$times((new Complex(Math.cos(2*Math.PI*k*n/N), dir*Math.sin(2*Math.PI*k*n/N)))));

                }
                if(dir==-1)
                    temp = temp.$div(N);
                result.add(temp);
            }
            return result;
        }

        public static ArrayList<Complex> fastFourierTime(ArrayList<Complex> a, int N, int dir){
            if(a.size()==1){
                return a;
            }
            ArrayList<Complex> odd = new ArrayList<>();
            ArrayList<Complex> even = new ArrayList<>();
            ArrayList<Complex> bEven;
            ArrayList<Complex> bOdd;
            for (int i = 0; i < N; i++){
                if(i % 2 == 0) {
                    even.add(a.get(i));
                }
                else {
                    odd.add(a.get(i));
                }
            }
            bEven = fastFourierTime(even, even.size(), dir);
            bOdd = fastFourierTime(odd, odd.size(), dir);

            ArrayList<Complex> y = new ArrayList<>();
            ArrayList<Complex> z = new ArrayList<>();

            Complex Wn = new Complex(Math.cos(2*Math.PI/N), dir*Math.sin(2*Math.PI/N));
            Complex W = new Complex(1.0, 0.0);

            for(int j=0; j<N/2; j++) {
                y.add(bEven.get(j).$plus(bOdd.get(j).$times(W)));
                z.add(bEven.get(j).$minus(bOdd.get(j).$times(W)));
                W = W.$times(Wn);
                }

            for(Complex temp:z){
                y.add(temp);
            }
            return y;
        }
    }
