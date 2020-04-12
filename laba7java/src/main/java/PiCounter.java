import java.util.ArrayList;
import java.util.Random;

public class PiCounter {
    private double threads;
    private double iterations;
    public PiCounter(double Threads, double Iterations){
        this.threads = Threads;
        this.iterations = Iterations;
    }

    ArrayList<Double> AllPisList = new ArrayList<Double>();
    public void GetPiParallel(){
        long time = System.currentTimeMillis();
        for(int i=1; i <= threads; i++){
            CountThread c = new CountThread(iterations/threads, this);
            c.start();
            try{c.join();}
            catch(InterruptedException e){ System.out.println("Thread has been interrupted");}
        }
        FinalOutput(time);
    }
    void FinalOutput(long time){
        System.out.println("Pi is: " + MiddlePi());
        System.out.println("Threads: " + threads);
        System.out.println("Iterations: " + iterations);
        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }


    public void GetPi(int radius, double iterations)
    {
        double dotsInCircleCount = 0;
        int radius2 = radius * radius;
        Random r = new Random();
        for (int i = 0; i < iterations; i++)
        {
            double x = r.nextDouble() ;
            double y = r.nextDouble() ;
            if ((y * y)  + (x * x) <= radius2)
                dotsInCircleCount++;
        }
        double pi = 4.0 * dotsInCircleCount / iterations;
        AllPisList.add(pi);
        //System.out.println("П = "+ pi);
        //ShowAllPi();

    }
     double MiddlePi(){
        double sum = 0;
        for(double d: AllPisList){
            sum+=d;
        }
        double p = sum/(double)AllPisList.size();

        return p;
    }
     void ShowAllPi(){
        System.out.println("Pi list: ");
        for(double d: AllPisList){
           System.out.print(d + " ");
        }
         System.out.println("");
    }
}

