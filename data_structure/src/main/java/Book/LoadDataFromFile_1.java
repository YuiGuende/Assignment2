package Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadDataFromFile_1 {
public void loadDataFromFile(String filename) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        Insert(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
    }
    br.close();
}
}