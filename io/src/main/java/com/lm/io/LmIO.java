package com.lm.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流工具类
 */
public class LmIO {
    /**
     * 关闭IO流，如果出现异常不打印错误堆栈
     *
     * @param closeables IO流
     */
    public static void closeIO(Closeable... closeables) {
        closeIO(false, closeables);
    }

    /**
     * 关闭IO流
     *
     * @param isPrintStackTrace 如果出现异常是否打印错误堆栈
     * @param closeables        IO流
     */
    public static void closeIO(boolean isPrintStackTrace, Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    if (isPrintStackTrace) e.printStackTrace();
                }
            }
        }
    }

    /**
     * 包装OutputStream
     *
     * @param outputStream OutputStream
     * @return OutputWrapper
     */
    public static OutputStreamWrapper outputStreamWrapper(OutputStream outputStream) {
        return new OutputStreamWrapper(outputStream);
    }

    /**
     * 包装OutputStream
     *
     * @param file   文件
     * @param append 是否添加模式
     * @return OutputWrapper
     * @throws FileNotFoundException 找不到文件异常
     */
    public static OutputStreamWrapper outputStreamWrapper(File file, boolean append) throws FileNotFoundException {
        return new OutputStreamWrapper(new FileOutputStream(file, append));
    }

    /**
     * 包装InputStream
     *
     * @param inputStream InputStream
     * @return InputStreamWrapper
     */
    public static InputStreamWrapper inputStreamWrapper(InputStream inputStream) {
        return new InputStreamWrapper(inputStream);
    }

    /**
     * 包装InputStream
     *
     * @param file 文件
     * @return InputStreamWrapper
     * @throws FileNotFoundException 找不到文件异常
     */
    public static InputStreamWrapper inputStreamWrapper(File file) throws FileNotFoundException {
        return new InputStreamWrapper(new FileInputStream(file));
    }


    /**
     * @param content byte[2]
     * @return byte[2]转short (小端)
     */
    public static short bytes2ShortLE(byte[] content) {
        if (content == null || content.length != 2) {
            throw new IllegalArgumentException("bytes2ShortLE方法content参数长度必须为2");
        }
        return (short) ((content[0] & 0xFF) | (content[1] & 0xFF) << 8);
    }

    /**
     * @param content byte[2]
     * @return byte[2]转short (大端)
     */
    public static short bytes2Short(byte[] content) {
        if (content == null || content.length != 2) {
            throw new IllegalArgumentException("bytes2ShortLE方法content参数长度必须为2");
        }
        return (short) ((content[1] & 0xFF) | (content[0] & 0xFF) << 8);
    }

    /**
     * @param content byte[4]
     * @return byte[4]转int (小端)
     */
    public static int bytes2IntLE(byte[] content) {
        if (content == null || content.length != 4) {
            throw new IllegalArgumentException("bytes2Int方法content参数长度必须为4");
        }
        return (content[0] & 0xFF)
                | (content[1] & 0xFF) << 8
                | (content[2] & 0xFF) << 16
                | (content[3] & 0xFF) << 24;
    }

    /**
     * @param content byte[4]
     * @return byte[4]转int (大端)
     */
    public static int bytes2Int(byte[] content) {
        if (content == null || content.length != 4) {
            throw new IllegalArgumentException("bytes2Int方法content参数长度必须为4");
        }
        return (content[3] & 0xFF)
                | (content[2] & 0xFF) << 8
                | (content[1] & 0xFF) << 16
                | (content[0] & 0xFF) << 24;
    }

    /**
     * @param content byte[8]
     * @return byte[8]转long (小端)
     */
    public static long bytes2LongLE(byte[] content) {
        if (content == null || content.length != 8) {
            throw new IllegalArgumentException("bytes2LongLE方法content参数长度必须为8");
        }
        return (long) (content[0] & 0xFF)
                | (long) (content[1] & 0xFF) << 8L
                | (long) (content[2] & 0xFF) << 16L
                | (long) (content[3] & 0xFF) << 24L
                | (long) (content[4] & 0xFF) << 32L
                | (long) (content[5] & 0xFF) << 40L
                | (long) (content[6] & 0xFF) << 48L
                | (long) (content[7] & 0xFF) << 56L;}

    /**
     * @param content byte[8]
     * @return byte[8]转long (大端)
     */
    public static long bytes2Long(byte[] content) {
        if (content == null || content.length != 8) {
            throw new IllegalArgumentException("bytes2LongLE方法content参数长度必须为8");
        }
        return (long) (content[7] & 0xFF)
                | (long) (content[6] & 0xFF) << 8L
                | (long) (content[5] & 0xFF) << 16L
                | (long) (content[4] & 0xFF) << 24L
                | (long) (content[3] & 0xFF) << 32L
                | (long) (content[2] & 0xFF) << 40L
                | (long) (content[1] & 0xFF) << 48L
                | (long) (content[0] & 0xFF) << 56L;
    }

    /**
     * @param content byte[]
     * @return byte[]转16进制字符串
     */
    public static String bytes2HexString(byte[] content) {
        if (content == null || content.length == 0) return "";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            if (i > 0) stringBuilder.append(" ");

            if ((content[i] & 0xff) < 0x10) stringBuilder.append("0");

            stringBuilder.append(Integer.toHexString(content[i] & 0xFF));
        }

        return stringBuilder.toString().toUpperCase();
    }

    /**
     * @param content short
     * @return short转为byte[] (小端)
     */
    public static byte[] short2BytesLE(final short content) {
        byte[] result = new byte[2];
        result[1] = (byte) ((content >>> 8) & 0xff);
        result[0] = (byte) (content & 0xff);
        return result;
    }

    /**
     * @param content short
     * @return short转为byte[] (大端)
     */
    public static byte[] short2Bytes(final short content) {
        byte[] result = new byte[2];
        result[0] = (byte) ((content >>> 8) & 0xff);
        result[1] = (byte) (content & 0xff);
        return result;
    }

    /**
     * @param content int
     * @return int转为byte[] (小端)
     */
    public static byte[] int2BytesLE(final int content) {
        byte[] result = new byte[4];
        result[3] = (byte) ((content >>> 24) & 0xff);
        result[2] = (byte) ((content >>> 16) & 0xff);
        result[1] = (byte) ((content >>> 8) & 0xff);
        result[0] = (byte) (content & 0xff);
        return result;
    }

    /**
     * @param content int
     * @return int转为byte[] (大端)
     */
    public static byte[] int2Bytes(final int content) {
        byte[] result = new byte[4];
        result[0] = (byte) ((content >>> 24) & 0xff);
        result[1] = (byte) ((content >>> 16) & 0xff);
        result[2] = (byte) ((content >>> 8) & 0xff);
        result[3] = (byte) (content & 0xff);
        return result;
    }

    /**
     * @param content long
     * @return long转为byte[] (小端)
     */
    public static byte[] long2BytesLE(final long content) {
        byte[] result = new byte[8];
        result[7] = (byte) ((content >>> 56L) & 0xff);
        result[6] = (byte) ((content >>> 48L) & 0xff);
        result[5] = (byte) ((content >>> 40L) & 0xff);
        result[4] = (byte) ((content >>> 32L) & 0xff);
        result[3] = (byte) ((content >>> 24L) & 0xff);
        result[2] = (byte) ((content >>> 16L) & 0xff);
        result[1] = (byte) ((content >>> 8L) & 0xff);
        result[0] = (byte) (content & 0xff);
        return result;
    }

    /**
     * @param content long
     * @return long转为byte[] (大端)
     */
    public static byte[] long2Bytes(final long content) {
        byte[] result = new byte[8];
        result[0] = (byte) ((content >>> 56L) & 0xff);
        result[1] = (byte) ((content >>> 48L) & 0xff);
        result[2] = (byte) ((content >>> 40L) & 0xff);
        result[3] = (byte) ((content >>> 32L) & 0xff);
        result[4] = (byte) ((content >>> 24L) & 0xff);
        result[5] = (byte) ((content >>> 16L) & 0xff);
        result[6] = (byte) ((content >>> 8L) & 0xff);
        result[7] = (byte) (content & 0xff);
        return result;
    }

    /**
     * @param content short
     * @return 翻转Short
     */
    public static short reverseBytesShort(final short content) {
        return (short) ((content & 0xff00) >>> 8 | (content & 0x00ff) << 8);
    }

    /**
     * @param content int
     * @return 翻转Int
     */
    public static int reverseBytesInt(final int content) {
        return (content & 0xff000000) >>> 24
                | (content & 0x00ff0000) >>> 8
                | (content & 0x0000ff00) << 8
                | (content & 0x000000ff) << 24;
    }

    /**
     * @param content long
     * @return 翻转Long
     */
    public static long reverseBytesLong(final long content) {
        return (content & 0xff00000000000000L) >>> 56
                | (content & 0x00ff000000000000L) >>> 40
                | (content & 0x0000ff0000000000L) >>> 24
                | (content & 0x000000ff00000000L) >>> 8
                | (content & 0x00000000ff000000L) << 8
                | (content & 0x0000000000ff0000L) << 24
                | (content & 0x000000000000ff00L) << 40
                | (content & 0x00000000000000ffL) << 56;
    }

}
