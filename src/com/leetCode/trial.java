package com.leetCode;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class trial {
    public static void main(String[] args) {
        try {
            byte[] address = {104, 126, (byte) 196, (byte) 238};
            InetAddress[] addresses = InetAddress.getAllByName("www.oreilly.com");
            InetAddress ia = InetAddress.getByAddress(address);
            for (InetAddress add : addresses) {
                System.out.println(add);
            }
            System.out.print(ia);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find www.oreilly.com");
        }
    }
}