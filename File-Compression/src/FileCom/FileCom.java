/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileCom;

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
public class FileCom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
		{
			String zipFile = "C:\\Users\\user\\Desktop\\Example.zip";
			String sourceDirectory = "C:\\Users\\user\\Desktop\\Example";
			
			//create byte buffer
			byte[] buffer = new byte[1024];
			/*
			 * To create a zip file, use
			 * 
			 * ZipOutputStream(OutputStream out)
			 * constructor of ZipOutputStream class.
			 *  
			 */
			 
			 //create object of FileOutputStream
			 FileOutputStream fout = new FileOutputStream(zipFile);
			 
			 //create object of ZipOutputStream from FileOutputStream
			 ZipOutputStream zout = new ZipOutputStream(fout);
			 
			 //create File object from directory name
			 File dir = new File(sourceDirectory);
			 
			 //check to see if this directory exists
			 if(!dir.isDirectory())
			 {
			 	System.out.println(sourceDirectory + " is not a directory");
			 }
			 else
			 {
			 	File[] files = dir.listFiles();
			 	
                            for (File file : files) {
                                System.out.println("Adding " + file.getName());
                                //create object of FileInputStream for source file
                                FileInputStream fin = new FileInputStream(file);
                                /*
                                 * To begin writing ZipEntry in the zip file, use
                                 *
                                 * void putNextEntry(ZipEntry entry)
                                 * method of ZipOutputStream class.
                                 *
                                 * This method begins writing a new Zip entry to
                                 * the zip file and positions the stream to the start
                                 * of the entry data.
                                 */
                                zout.putNextEntry(new ZipEntry(file.getName()));
                                /*
                                * After creating entry in the zip file, actually
                                * write the file.
                                */
                                int length;
                                while((length = fin.read(buffer)) > 0)
                                {
                                    zout.write(buffer, 0, length);
                                }
                                /*
                                * After writing the file to ZipOutputStream, use
                                *
                                * void closeEntry() method of ZipOutputStream class to
                                * close the current entry and position the stream to
                                * write the next entry.
                                */
                                
                                zout.closeEntry();
                                //close the InputStream
                                fin.close();
                            }
			 }
		  
			  //close the ZipOutputStream
			  zout.close();
			  
			  System.out.println("Zip file has been created!");
		
		}
		catch(IOException ioe)
		{
			System.out.println("IOException :" + ioe);
		}
		
	}

    }
    
