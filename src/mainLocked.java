
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S2028398
 */
public class mainLocked implements methods{
    
    public static void main(String[] args)throws IOException {
        
        mainLocked add=new mainLocked();
        Scanner input = new Scanner(System.in);
        int a;
        do{
        System.out.println("***************************************************");
        System.out.println("*                  WELCOME                        *");
        System.out.println("*                                                 *");
        System.out.println("*        APPLICATION NAME: LOCKED ME              *");
        System.out.println("*     Developer Details: Ramurebiwa Terry         *");
        System.out.println("*                                                 *");
        System.out.println("*           Choose from Option Below!!            *");
        System.out.println("*                                                 *");
        System.out.println("* 1. Retrieve Current Filenames In Asending Order *");
        System.out.println("* 2. Business Level Operation Menu                *");
        System.out.println("* 3. Exit From The Application                    *");
        System.out.println("*                                                 *");
        System.out.println("***************************************************");
        
        
        System.out.println("\nSelect From The Options Above ");
        a=input.nextInt();
        
        switch(a){
            case 1:System.out.println("------Current Filenames------");
                add.showAllFile();
                break;
            case 2:System.out.println("------Business Level Operation Menu------");

            int b;
            do{
            System.out.println("------------------------------------------------");
            System.out.println("| 1. Add a file and its contents to directory   |");
            System.out.println("| 2. Delete a file from a dirctory              |");
            System.out.println("| 3. Search a file and showing its content      |");
            System.out.println("| 4. Exit from BOL menu                         |");
            System.out.println("------------------------------------------------");
            
                            System.out.println("\nSelect From The Business Options Above ");
                            b=input.nextInt();
                          
                            
                            switch(b){
                                case 1:System.out.println("Add afile and its contents to directory");
                                    System.out.println("Enter Name Of File you want to add");
                                    String c = input.next();
                                    add.addFile(c); 
                                    break;
                                case 2:System.out.println("Delete a file from a dirctory");
                                    System.out.println("Enter Name Of File you want to delete");
                                    String deleteName = input.next();
                                    add.deleteFile(deleteName);
                                    break;
                                 case 3:System.out.println("Search a file and showing its content");
                                    System.out.println("Enter Name of the file here");
                                    String sear = input.next();
                                    add.searchFile(sear);
                                    break;
                                case 4:System.out.println("Exit from BOL menu");
                                System.exit(0);
                                
                                    break;
                                    default:
                                        System.out.println("invalid check again and try'");
                                    }
                            }while(b!=5);
                break;
            case 3:System.out.println("Exit from Application");
            System.exit(0);
                break;
                
            default:
                System.out.println("***Invalid Option,Try Again***11");
            }
        }while(a!=4);       
    }
    @Override
    public void showAllFile() {
        String pathf="D:\\Users\\s2028398\\Downloads\\files";
        File folder=new File(pathf);
        File[] text = folder.listFiles();
        
        for (File file:text) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }else if (file.isDirectory()){
                System.out.println("Folder"+" "+file.getName());
               
            }
            
        }
    }

    @Override
    public void addFile(String c) {
                File file = new File("D:\\Users\\s2028398\\Downloads\\files\\"+c+".txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File Created Successfully");
            } else {
                System.out.println("File already exist");
            FileWriter writer=new FileWriter(file);

                writer.write(c);

                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(mainLocked.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteFile(String deleteName) {
               try {
            Files.deleteIfExists(Paths.get("D:\\Users\\s2028398\\Downloads\\files\\"+deleteName+".txt"));
        } catch (NoSuchFileException e) {

            e.printStackTrace();
        } catch (DirectoryNotEmptyException e) {

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Invalid Permission");

        }

        System.out.println("File deleted succsefully");
    }
    
    public List<String>FileList(){
    List<String>text=new ArrayList<>();
    File dir=new File("D:\\Users\\s2028398\\Downloads\\files");
    for (File e : dir.listFiles()){
        if(e.getName().endsWith((".txt"))){
            System.out.println(e.getName());
            }
        }
    return text;
    } 

    @Override
    public List<String> searchFile(String sear) {
        	
    List<String> lines=Collections.emptyList();

    try {

    lines=Files.readAllLines(Paths.get(sear),StandardCharsets.UTF_8);

    } catch (IOException e) {

    e.printStackTrace();
        System.out.println("No file Founded!!");

    }

return lines;
    }

  }

