package com.nice.begin;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel sc) throws Exception {

        ChannelPipeline pipeline = sc.pipeline();
        //处理http消息的编解码
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        //HttpObjectAggregator 这个 ChannelHandler作用就是将请求转换为单一的 FullHttpRequest。
        pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
        //添加自定义的ChannelHandler
        //pipeline.addLast("httpServerHandle",new HttpServerHandler());
        pipeline.addLast("httpServerHandle0 ",new HttpServerHandler0());

    }
}
