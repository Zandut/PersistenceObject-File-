/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenceobject.file;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PRAKTIKUM
 */
public class PersistenceObjectFile {

    /**
     * @param args the command line arguments
     */
    
    public static void insertObject(ArrayList<Mahasiswa> array, Mahasiswa m)
    {
        File f = new File("Data.txt");
        ObjectOutputStream dos = null;
        try {
            dos = new ObjectOutputStream(new FileOutputStream(f));
            
            array.add(m);
            
            dos.writeObject(array);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersistenceObjectFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersistenceObjectFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Mahasiswa> getObject()
    {
        File f = new File("Data.txt");
        
         try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            ArrayList<Mahasiswa> arrayMhs = (ArrayList<Mahasiswa>) ois.readObject();
            return arrayMhs;
            
        }
        catch (EOFException ex)
        {
            return new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(PersistenceObjectFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersistenceObjectFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        
        int pil = -1;
        while (pil != 3)
        {
            System.out.println("---Menu Utama---");
            System.out.println("1. Insert Object");
            System.out.println("2. Display Object");
            System.out.println("3. Keluar ");
            System.out.print("Masukkan Pilihan : ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    System.out.println("---Insert Object---");
                    Mahasiswa m = new Mahasiswa();
                    
                    System.out.print("Masukkan NIM ");
                    m.setNim(input.next());
                    System.out.print("Masukkan nama ");
                    m.setNama(input.next());
                    
                    //get Array agar bisa di update
                    ArrayList<Mahasiswa> array = getObject();
                        
                   
                    
                    //insert ke file
                    PersistenceObjectFile.insertObject(array, m);
                    System.out.println("Berhasil !!");
                    
                    
                    break;
                case 2:
                    System.out.println("---Display Object---");
                    ArrayList<Mahasiswa> array1 = getObject();
                   
                    for(Mahasiswa m1 : array1)
                    {
                        System.out.println(m1.toString());
                        System.out.println("------------------------");
                    }
                    
                    
                    break;
                case 3:
                    
                    
                    break;
            }
            
        }
        
        
       
        
    }
    
}
