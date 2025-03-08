package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderList {
    private ReaderNode head;

    public void loadFile(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 3) {
                    String rcode = parts[0].trim();
                    String name = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    addToEnd(new Reader(rcode, name, year));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            }
        }
                  
    private void addToEnd(Reader reader) {

    }
}

    
