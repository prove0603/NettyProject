package com.atguigu.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel01 {
    public static void main(String[] args) throws IOException {
        String a="Hello,庄杰";

        FileOutputStream fileOutputStream=new FileOutputStream("D:\\AtGuiGu\\nio01.txt");

        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(a.getBytes());

        byteBuffer.flip();

        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
