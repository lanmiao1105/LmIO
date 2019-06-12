# LmIO
Java IO包装库

#### OutputStream包装类--OutputStreamWrapper
OutputStream包装类会先写入缓冲区，缓冲区满了自动写入输出流，或者调用`flush()`强制写入输出流
```
OutputStreamWrapper outputStreamWrapper = null;
        try {
            File file = new File("test_io.txt");
            outputStreamWrapper = LmIO.outputStreamWrapper(file, false);
            outputStreamWrapper
                    .writeByte(Byte.MIN_VALUE)//缓冲区写入1个字节
                    .writeShort(Short.MIN_VALUE)//缓冲区写入2个字节(大端序)
                    .writeShortLE(Short.MAX_VALUE)//缓冲区写入2个字节(小端序)
                    .writeInt(Integer.MIN_VALUE)//缓冲区写入4个字节(大端序)
                    .writeIntLE(Integer.MAX_VALUE)//缓冲区写入4个字节(小端序)
                    .writeLong(Long.MAX_VALUE)//缓冲区写入8个字节(大端序)
                    .writeLongLE(Long.MIN_VALUE)//缓冲区写入8个字节(小端序)
                    .writeUTF8("UTF-8 String\n")//缓冲区写入UTF-8字符串
                    .flush();//缓冲区强制写入文件
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStreamWrapper != null) outputStreamWrapper.close();
        }
```

#### InputStream包装类--InputStreamWrapper
InputStreamWrapper会先读满一个缓冲区，然后读取操作会从缓冲区中直接读取相应的字节数出来。
如果所需要读取的字节数超出缓冲区剩余未读的字节数，则会再读满一个缓冲区，以此内推。
```
InputStreamWrapper inputStreamWrapper = null;
        try {
            File file = new File("test_io.txt");
            inputStreamWrapper = LmIO.inputStreamWrapper(file);
            byte b = inputStreamWrapper.readByte();//读1个字节
            short s1 = inputStreamWrapper.readShort();//读2个字节(大端序)
            short s2 = inputStreamWrapper.readShortLE();//读2个字节(小端序)
            int i1 = inputStreamWrapper.readInt();//读4个字节(大端序)
            int i2 = inputStreamWrapper.readIntLE();//读4个字节(小端序)
            long l1 = inputStreamWrapper.readLong();//读8个字节(大端序)
            long l2 = inputStreamWrapper.readLongLE();//读8个字节(小端序)
            String line = inputStreamWrapper.readUTF8Line();//读一行UTF-8字符串
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamWrapper != null) inputStreamWrapper.close();
        }
```