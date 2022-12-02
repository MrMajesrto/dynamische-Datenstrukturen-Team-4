package de.hebk.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import de.hebk.gamemode.*;
import de.hebk.model.list.*;

public class CSVReader {

    public List<Questions> readCSVList(String path){
        List<Questions> l1 = new List<Questions>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String[] questions = new String[4];
                for(int i = 0, j = 2; i < questions.length; i++,j++){
                    questions[i] = arr[j];
                }
                int diff = Integer.parseInt(arr[1]);
                l1.append(new Questions(arr[0], questions,arr[2],diff));
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return l1;
    }
}
