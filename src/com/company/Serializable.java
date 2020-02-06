package com.company;

import java.io.*;

public class Serializable {


    public static void main(String[] args) throws IOException{
        Student stu = new Student(123, "dj");

        FileOutputStream fout = new FileOutputStream("C:\\Users\\surya\\Desktop\\new.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(stu);
        out.flush();
        System.out.println("done");


    }
}
