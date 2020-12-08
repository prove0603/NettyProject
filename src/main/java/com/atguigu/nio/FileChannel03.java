package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel03 {
    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(10);

        while (true){
//            byteBuffer.clear();
            int read = fileInputStreamChannel.read(byteBuffer);
            if (read==-1) break;
            byteBuffer.flip();
            fileOutputStreamChannel.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
