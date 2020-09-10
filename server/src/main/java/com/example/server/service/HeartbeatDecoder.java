package com.example.server.service;

import com.example.server.vo.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HeartbeatDecoder extends ByteToMessageDecoder {
    private final static Logger LOGGER = LoggerFactory.getLogger(HeartbeatDecoder.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        LOGGER.info("Server in.capacity:",in.capacity());
        long id = in.readLong();
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes) ;
        String content = new String(bytes) ;

        CustomProtocol customProtocol = new CustomProtocol() ;
        customProtocol.setId(id);
        customProtocol.setContent(content) ;
        out.add(customProtocol) ;

    }
}
