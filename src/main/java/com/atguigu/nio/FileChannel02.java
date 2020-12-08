package com.atguigu.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel02 {
    public static void main(String[] args) throws Exception{
        File file=new File("D:\\AtGuiGu\\nio01.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());

        channel.read(buffer);

        System.out.println(new String(buffer.array()));
    }
}
