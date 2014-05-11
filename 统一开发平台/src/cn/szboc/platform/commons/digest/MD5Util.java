package cn.szboc.platform.commons.digest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 对某个实体数�?File或�?byte[])进行MD5消息摘要计算的组�?
 */
public abstract class MD5Util {

    // 读取文件时用于缓存.默认使用1024字节,1M内存空间
    private static int defaultBufferSize = 1024;

    /**
     * 对[字节数组]进行MD5消息摘要的计算主要用于存储于JVM内存中少量字节数组的校验
     * 
     * @param data
     *            要计算摘要的字节数组
     * @return 返回计算好的信息摘要
     * @throws Exception
     *             如果参数非法,内部IO异常,则抛出对应异常
     */
    public static byte[] caculate(byte[] data) throws Exception {
        // 参数校验
        if (data == null) {
            throw new IllegalArgumentException("参数data不能为空");
        }

        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 执行消息摘要的计算
        return md.digest(data);
    }

    /**
     * 对[磁盘文件]进行MD5消息摘要的计算主要用于存储于磁盘上体积较大的文件的校验
     * 
     * @param file
     *            磁盘文件的File引用
     * @return 返回计算好的信息摘要
     * @throws Exception
     *             如果参数非法,内部IO异常,则抛出对应异常
     */
    public static byte[] caculate(File file) throws Exception {

        // 参数校验
        if (file == null) {
            throw new IllegalArgumentException("参数file不能为空");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException("参数file指向路径[" + file.getCanonicalPath() + "]不存在");
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("参数file指向路径[" + file.getCanonicalPath() + "]不是有效合法文件");
        }

        // 建立文件缓存输入�?
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));

            return caculate(bis);
        } finally {
            try {
                // 必须关闭文件以释放资源
                if (bis != null) {
                    bis.close();
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 对[输入流]进行MD5消息摘要的计算,主要用于网络上的IO流的校验
     * 
     * @param is
     *            二进制输入流
     * @return 返回计算好的信息摘要
     * @throws Exception
     *             如果参数非法,内部IO异常,则抛出对应异常
     */
    public static byte[] caculate(InputStream is) throws Exception {

        // 参数校验
        if (is == null) {
            throw new IllegalArgumentException("参数is不能为空");
        }

        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 对于文件的摘要计�?不能�?��全部读入内存,否则可能会�?成内存溢�?�?��利用缓冲区进行分步计�?
        byte[] buffer = new byte[defaultBufferSize];

        // 标识每次读取的字节长�?
        int readLength = -1;

        // 循环读取,直到读取完毕,即输入流返回-1
        while ((readLength = is.read(buffer)) != -1) {
            // 每次读取后进行MD5值的更新
            md.update(buffer, 0, readLength);
        }

        return md.digest();
    }

}
