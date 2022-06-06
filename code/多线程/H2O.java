package 多线程;

class H2O {
    private int countH = 0;
    private int countO = 0;
    private Object object = new Object();
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        synchronized (object){
            if (countH == 2)
               {
                   if(countO == 0)
                       object.wait();

                   countH = 0;
               }
            else{
                countH++;
                releaseHydrogen.run();
                if (countH == 2)
                    object.notify();
            }
        }


    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        synchronized (object){
            if(countO == 1){
                if(countH < 2)
                    object.wait();

                countO = 0;
            }
            else{
                countO = 1;
                releaseOxygen.run();
                object.notify();
            }
        }

    }
}