package br.edu.utfpr.td.tsi.consumer.util;

public class Timer {
    public static void awaitOneSecond(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
