/*
 * Copyright (c) 2022-2024 KCloud-Platform-IoT Author or Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.laokou.im.handler;

import io.netty.channel.*;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.laokou.common.netty.config.WebSocketSession;
import org.springframework.stereotype.Component;

/**
 * WebSocket自定义处理器.
 *
 * @author laokou
 */
@Slf4j
@Component
@ChannelHandler.Sharable
@RequiredArgsConstructor
public class WebSocketServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent event) {
			if (event.state() == IdleState.READER_IDLE) {
				log.error("读取空闲，关闭连接");
				ctx.close();
			}
			else {
				super.userEventTriggered(ctx, evt);
			}
		}
	}

	@Override
	@SneakyThrows
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		if (msg instanceof WebSocketFrame frame) {
			if (frame instanceof PingWebSocketFrame pingWebSocketFrame) {
				ctx.writeAndFlush(new PongWebSocketFrame(pingWebSocketFrame.content().retain()));
			}
			else if (frame instanceof TextWebSocketFrame textWebSocketFrame) {
				read(ctx, textWebSocketFrame);
			}
			else {
				super.channelRead(ctx, msg);
			}
		}
		else {
			super.channelRead(ctx, msg);
		}
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		log.info("建立连接：{}", ctx.channel().id().asLongText());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		String channelId = ctx.channel().id().asLongText();
		log.info("断开连接：{}", channelId);
		WebSocketSession.remove(channelId);
	}

	private void read(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
		Channel channel = ctx.channel();
		String authorization = frame.text();
		// TODO reactive feign调用
		// if (obj != null) {
		// UserDetail userDetail = (UserDetail) obj;
		// Long id = userDetail.getId();
		// WebSocketSession.put(id.toString(), channel);
		// }
		// else {
		// if (channel.isActive() && channel.isWritable()) {
		// channel.writeAndFlush(new
		// TextWebSocketFrame(JacksonUtil.toJsonStr(Result.fail(UNAUTHORIZED))));
		// ctx.close();
		// }
		// else {
		// log.error("丢弃消息");
		// }
		// }
	}

}
