package com.ouyangliuy.Memory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;


public class Memory {

    public static void main(String[] args) {
        PooledByteBufAllocator allocator = new PooledByteBufAllocator();

        for (int i = 0; i < 512; i++) {
            allocator.buffer(1);
        }
        ByteBuf s = allocator.buffer(4 * 1024);     // 4KB
        ByteBuf ss = allocator.buffer(4);
        ByteBuf m = allocator.buffer(2 * 8 * 1024);   // 16KB
        ByteBuf l = allocator.buffer(2 * 8 * 1024 * 1024);   // 16M
        ByteBuf ll = allocator.buffer(2 * 2 * 8 * 1024 * 1024);   // 32M
        ll.release();
    }
}
