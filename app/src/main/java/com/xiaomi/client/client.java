package com.xiaomi.client;

import main.java.test;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class client {
    public static void main(String[] args) {
        System.out.println("客户端启动....");
        TTransport transport = null;
        try {
            transport = new TSocket("localhost", 7911, 30000);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            test.Client client = new test.Client(protocol);
            transport.open();
            String result = client.helloString("哈哈");
            System.out.println(result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }
}
