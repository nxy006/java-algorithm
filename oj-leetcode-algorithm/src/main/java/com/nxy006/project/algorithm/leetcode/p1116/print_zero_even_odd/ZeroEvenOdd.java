package com.nxy006.project.algorithm.leetcode.p1116.print_zero_even_odd;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * 条件队列解法
 *
 * Runtime  7 ms  , beats 100.00 % of java submissions.
 * Memory   38 MB , beats  72.63 % of java submissions.
 * 08/14/2021 11:51
 */
public class ZeroEvenOdd {
    private int n;
    private int i;
    private Object lock = new Object();
    private boolean isStop;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.i = 1;
        this.isStop = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            synchronized(lock) {
                while(!isStop && i % 2 != 1) {
                    lock.wait();
                }

                if(isStop || i > 2*n) {
                    this.isStop = true;
                    lock.notifyAll();
                    return ;
                }

                printNumber.accept(0);
                i++;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            synchronized(lock) {
                while(!isStop &&i % 4 != 0) {
                    lock.wait();
                }

                if(isStop || i > 2*n) {
                    this.isStop = true;
                    lock.notifyAll();
                    return ;
                }

                printNumber.accept(i/2);
                i++;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            synchronized(lock) {
                while(!isStop && (i % 2 != 0 || i % 4 == 0)) {
                    lock.wait();
                }

                if(isStop || i > 2*n) {
                    this.isStop = true;
                    lock.notifyAll();
                    return ;
                }

                printNumber.accept(i/2);
                i++;
                lock.notifyAll();
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new ZeroEvenOdd(2), "0102", new String[]{"zero", "even", "odd"});
        caseCheck(new ZeroEvenOdd(2), "0102", new String[]{"odd", "zero", "even"});
        caseCheck(new ZeroEvenOdd(5), "0102030405", new String[]{"odd", "zero", "even"});
    }

    private static void caseCheck(ZeroEvenOdd zeroEvenOdd, String expected, String[] commends) {
        IntPrintConsumer.clearOutput();
        List<Thread> threads = new ArrayList<>();
        for(String commend : commends) {
            Thread thread = new ZeroEvenOddThread(zeroEvenOdd, new IntPrintConsumer(commend), commend);
            threads.add(thread);
            thread.start();
        }
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CaseAssertUtils.assertEquals(expected, IntPrintConsumer.getOutput());
    }

    private static class ZeroEvenOddThread extends Thread {
        private ZeroEvenOdd zeroEvenOdd;
        private IntConsumer intConsumer;
        private String commend;

        public ZeroEvenOddThread(ZeroEvenOdd zeroEvenOdd, IntConsumer intConsumer, String commend) {
            this.zeroEvenOdd = zeroEvenOdd;
            this.intConsumer = intConsumer;
            this.commend = commend;
        }

        @Override
        public void run() {
            super.run();
            try {
                switch (commend) {
                    case "zero": zeroEvenOdd.zero(intConsumer);break;
                    case "odd":  zeroEvenOdd.odd(intConsumer);break;
                    case "even": zeroEvenOdd.even(intConsumer);break;
                    default:
                        throw new RuntimeException("You passed invalid value. Exiting.");
                }
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex);
            }
        }
    }

    private static class IntPrintConsumer implements IntConsumer {
        private static final StringBuffer stringBuffer = new StringBuffer();
        private final String commend;

        public IntPrintConsumer(String commend) {
            this.commend = commend;
        }

        @Override
        public void accept(int value) {
            switch (commend) {
                case "zero": if (value == 0) { break; }
                case "odd":  if (value % 2 == 1) { break; }
                case "even": if (value % 2 == 0) { break; }
                default:
                    throw new RuntimeException("You passed invalid value. Exiting.");
            }
            stringBuffer.append(value);
        }

        public static String getOutput() {
            return stringBuffer.toString();
        }

        public static void clearOutput() {
            stringBuffer.setLength(0);
        }
    }
}

