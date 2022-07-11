package 多线程;

class FooBar {
    private int n;
    private Object object = new Object();
    private boolean flag = false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (object){
                if(flag)
                    object.wait();
                printFoo.run();
                flag = true;
                object.notify();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (object){
                if(!flag)
                    object.wait();
                printBar.run();
                flag = false;
                object.notify();

            }
        }
    }
}