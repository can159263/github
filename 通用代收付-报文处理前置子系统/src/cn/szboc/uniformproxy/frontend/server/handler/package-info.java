
/**
 * netty的通道处理器
 * 
 * 0, 系统别校验
 * 1, 报文接收,长度截取,形成字节数组
 * 2, 权衡系统负载
 * 3, 提交任务到线程池
 * 
 */
package cn.szboc.uniformproxy.frontend.server.handler;