package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannel04 {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutputStream=new FileOutputStream("E:\\2.jpg");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        FileInputStream fileInputStream=new FileInputStream("E:\\1.jpg");
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        outputStreamChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());

        fileInputStream.close();
        fileOutputStream.close();
        outputStreamChannel.close();
        inputStreamChannel.close();

    }
}
