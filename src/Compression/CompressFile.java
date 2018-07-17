/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author user
 */
public class CompressFile {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)throws Exception{
        // TODO code application logic here
        zipFolder("C:\\Users\\user\\Desktop\\Example","C:\\Users\\user\\Desktop\\Example.zip");
    }
    static public void zipFolder(String srcFolder,String destZipFile)throws Exception{
        ZipOutputStream zip=null;
        FileOutputStream fileWriter=null;
        fileWriter=new FileOutputStream(destZipFile);
        zip=new ZipOutputStream(fileWriter);
        
        addFolderToZip("",srcFolder,zip);
        zip.flush();
        zip.close();
    }
    static private void addFileToZip(String path,String srcFile,ZipOutputStream zip)throws Exception{
        File folder=new File(srcFile);
        if(folder.isDirectory()){
            addFolderToZip(path,srcFile,zip);
        }else{
           byte[] buffer=new byte[1024];
           int len;
           FileInputStream in=new FileInputStream(srcFile);
           zip.putNextEntry(new ZipEntry(path+"/"+folder.getName()));
           while((len=in.read(buffer))>0){
               zip.write(buffer, 0, len);
           }
        }
    }
    static private void addFolderToZip(String path,String srcFolder,ZipOutputStream zip)throws Exception{
        File folder=new File(srcFolder);
        for(String fileName: folder.list()){
            if(path.equals("")){
                addFileToZip(folder.getName(), srcFolder+"/"+fileName, zip);
            }else{
            addFileToZip(path+"/"+folder.getName(), srcFolder+"/"+fileName, zip);
        }
        }
    }
    
}
