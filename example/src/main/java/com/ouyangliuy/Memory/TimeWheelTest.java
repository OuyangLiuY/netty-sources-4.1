package com.ouyangliuy.Memory;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class TimeWheelTest {

    public static void main(String[] args) throws Exception {


        HashedWheelTimer wheelTimer = new HashedWheelTimer();
        wheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println(1);
            }
        }, 100, TimeUnit.MILLISECONDS);

        Thread.sleep(500);
        final long start = System.currentTimeMillis();
        wheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                long end = System.currentTimeMillis();
                System.out.println(end - start);
            }
        }, 1000, TimeUnit.MILLISECONDS);
    }
}
