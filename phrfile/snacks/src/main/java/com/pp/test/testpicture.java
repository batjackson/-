package com.pp.test;

import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class testpicture {
    @Test
    public void test() throws IOException {

        String s=testpicture.class.getResource("../../../")+"1.1.jpg";
        s=s.substring(6);
        System.out.println(s);
//        FileInputStream fis=new FileInputStream(s);
//        FileOutputStream fos =new FileOutputStream("C:/java/1.jpg");
//
//        byte[] bys=new  byte[1024];
//        int len;
//        while((len=fis.read(bys))!=-1){
//            fos.write(bys,0,len);
//        }
//        fos.close();
//        fis.close();
    }

}
