package com.ouyangliuy.Memory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.PlatformDependent;

import java.util.Random;


public class Memory {

    public static void main(String[] args) {
        PooledByteBufAllocator allocator = new PooledByteBufAllocator();

        StaticClassTest test = new StaticClassTest();

        for (int i = 0; i < 512; i++) {
            allocator.buffer(1);
        }
        ByteBuf s = allocator.buffer(4 * 1024);     // 4KB
        ByteBuf ss = allocator.buffer(4);
        ByteBuf m = allocator.buffer(2 * 8 * 1024);   // 16KB
        ByteBuf l = allocator.buffer(2 * 8 * 1024 * 1024);   // 16M
        ByteBuf ll = allocator.buffer(2 * 2 * 8 * 1024 * 1024);   // 32M
        ll.writeZero(ll.capacity());
        ll.release();

//        ReferenceCountUtil.release(ll);

        int anInt = PlatformDependent.threadLocalRandom().nextInt(128);
        System.out.println(anInt);
        Random random = new Random();
        System.out.println(random.nextInt(100));
        int a = 10;
        while (a != 0){
            a = random.nextInt(100);
            if(a == 0){
                System.out.println("00");
            }
        }

    }
}
