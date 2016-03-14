package com.ricky.codelab.netty.ch3;

import java.util.List;

import com.ricky.codelab.netty.model.User;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class KyroClientHandler extends ChannelInboundHandlerAdapter {

    private final List<User> message;

    /**
     * Creates a client-side handler.
     */
    public KyroClientHandler(List<User> message) {
    	this.message = message;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // Send the message to Server
        super.channelActive(ctx);
        System.out.println("client send message");
        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        // you can use the Object from Server here
        System.out.println("client receive:"+msg);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        
    	cause.printStackTrace();
        ctx.close();
    }
}