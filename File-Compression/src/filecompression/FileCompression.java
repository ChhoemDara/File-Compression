/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filecompression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author user
 */
public class FileCompression {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException{
        // TODO code application logic here
        String sourceFile="testing.txt";
        FileOutputStream fos = new FileOutputStream("D:\\compressed.zip");
        ZipOutputStream zipout=new ZipOutputStream(fos);
        File filetozip=new File(sourceFile);
        FileInputStream fis=new FileInputStream(filetozip);
        ZipEntry zipentry=new ZipEntry(filetozip.getName());
        zipout.putNextEntry(zipentry);
        final byte[] bytes= new byte[1024];
        int length;
        while((length=fis.read(bytes))>=0){
            zipout.write(bytes, 0, length);
        }
        zipout.close();
        fis.close();
        fos.close();
        
    }
    
}
