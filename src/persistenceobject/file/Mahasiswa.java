/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenceobject.file;

import java.io.Serializable;

/**
 *
 * @author PRAKTIKUM
 */
public class Mahasiswa implements Serializable{
    private String nim;
    private String nama;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public String toString() {
        return "NIM : "+getNim()+"\nNama : "+getNama();
    }
    
    
    
}
