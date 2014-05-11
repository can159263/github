
/**
 * 报文前置处理,分别包括一下几个步骤
 * 
 * 其中PreProcessor实例是需要利用Spring容器注入的
 * 
 * 1, 二进制数据的MD5验证; @see MD5ParseException
 * 2, 解压缩; @see MD5ParseException
 * 3, 解密; @see MD5ParseException
 * 4, 将XML数据转为Bean对象. @see PreProcessor
 */
package cn.szboc.uniformproxy.frontend.server.preprocess;