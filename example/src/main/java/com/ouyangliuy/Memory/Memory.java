package com.ouyangliuy.Memory;

import io.netty.buffer.PooledByteBufAllocator;

public class Memory {


    public static void main(String[] args) {

        PooledByteBufAllocator allocator = new PooledByteBufAllocator();
       /* int[] init = {1,250,500,512,600,1024,4096,800000};
        for (int i = 0; i < init.length; i++) {
            ByteBuf buffer = allocator.buffer(init[i]);
            System.out.println(buffer.capacity());
        }*/
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
        allocator.buffer(1);
    }
}
