package com.atguigu.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/12/5 14:08
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool= Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("****************服务端启动了");

        while (true){
            final Socket socket = serverSocket.accept();
            System.out.println("*****************连接到了一个客户端");
            threadPool.execute(()->{
                handler(socket);
            });
        }
    }

    public static void handler(Socket socket){
        System.out.println("当前线程ID:  "+Thread.currentThread().getId()+"  当前线程姓名：  "+Thread.currentThread().getName());
        byte[] bytes = new byte[1024];
//        通过Socket  获得输入流
        try {
            InputStream inputStream = socket.getInputStream();
//            循环读取客户端发送的数据
            while (true){
                System.out.println("当前线程ID:  "+Thread.currentThread().getId()+"  当前线程姓名：  "+Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭Socket连接");
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
