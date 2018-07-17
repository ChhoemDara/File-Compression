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
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 *
 * @author user
 */
public class MultiFile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        List<String> srcFiles=Arrays.asList("test1.txt","test2.txt");
        FileOutputStream fos=new FileOutputStream("multicompress.zip");
        ZipOutputStream zipOut=new ZipOutputStream(fos);
        for(String srcFile: srcFiles){
            File filetoZip=new File(srcFile);
            FileInputStream fis=new FileInputStream(filetoZip);
            ZipEntry zipentry =new ZipEntry(filetoZip.getName());
            zipOut.putNextEntry(zipentry);
            
            byte[] bytes=new byte[1024];
            int length;
            while((length=fis.read())>=0){
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }
    
}

