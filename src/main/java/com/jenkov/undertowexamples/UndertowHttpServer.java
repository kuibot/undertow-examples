package com.jenkov.undertowexamples;

import io.undertow.Undertow;

import java.io.IOException;

public class UndertowHttpServer {

    public static void main(String[] args) throws IOException {
        String ipAddress = "127.0.0.1";
        String operatingSystem = "1";
        int tcpPort = 80;

        System.out.println("ip address: " + ipAddress);
        System.out.println("OS        : " + operatingSystem);

        //SSLUtil.setDownloadSslContext();

        System.out.println("Undertow starting");

        System.out.println("Building Undertow server");
        Undertow.Builder builder = Undertow.builder();
        Undertow undertow = builder
                //.addHttpListener(80, "localhost")
                //.addHttpListener(80, "135.181.102.160")
                .addHttpListener(tcpPort, ipAddress)
                //.addHttpListener(80, "ec2-52-17-198-128.eu-west-1.compute.amazonaws.com")
                //.setHandler(new WebHandler(cmsHandler))
                //.setHandler(new SimpleHandler())
                //.setHandler(new FileHandler("assets/"))
                .setHandler(new DownloadProxyHandler())
                .build();

        System.out.println("Undertow started");
        undertow.start();

    }

}
