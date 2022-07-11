package 多线程.交替打印字符串;

import java.util.function.*;

class FizzBuzz {
    private int n;
    private int i;
    public FizzBuzz(int n) {
        this.n = n;
        i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException { //被3整除
        synchronized (this){
            while (i <= n){
                if(i % 3 == 0 && i % 5 != 0){
                    printFizz.run();
                    this.notifyAll();
                    i++;
                }
                else
                    this.wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {//被5整除
        synchronized (this){
            while (i <= n){
                if(i % 3 != 0 && i % 5 == 0){
                    printBuzz.run();
                    this.notifyAll();
                    i++;
                }
                else
                    this.wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException { //被3 和 5整除
        synchronized (this){
            while (i <= n){
                if(i % 3 == 0 && i % 5 == 0){
                    printFizzBuzz.run();
                    this.notifyAll();
                    i++;
                }
                else
                    this.wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {//不被3和5整除
        synchronized (this){
            while (i <= n){
                if(i % 3 != 0 && i % 5 != 0){
                    printNumber.accept(i);
                    this.notifyAll();
                    i++;
                }
                else
                    this.wait();
            }
        }
    }
}