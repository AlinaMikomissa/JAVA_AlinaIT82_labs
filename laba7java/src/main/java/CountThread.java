public class CountThread extends Thread  {
   // Наша очередь из сотрудников, наследник класса Thread
        private double iterations;
        private PiCounter counter;
    CountThread(double Iterations, PiCounter piCounter) {//
            this.iterations = Iterations;
            this.counter = piCounter;
        }
        @Override
        public void run() {
              try {
                counter.GetPi(1, iterations);
               } catch (Exception e) {}

        }

    }
