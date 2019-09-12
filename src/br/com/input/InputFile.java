package br.com.input;

import br.com.config.App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class InputFile {

    public void startUp(Integer size)
            throws IOException {
        for (int i = 1; i <= App.NUMBER_FILES; i++) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.createFile(App.FILE + i)));
            for (Integer item : this.randomList(size)) writer.write(item.toString() + "\n");
            writer.close();
        }
    }

    private File createFile(String filename) throws IOException {
        File file = new File(App.folder() + filename);
        if (file.exists())
            file.delete();
        file.createNewFile();
        return file;
    }

    private ArrayList<Integer> randomList(Integer size) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < size.intValue(); i++) {
            list.add(rand.nextInt(size));
        }

        return list;
    }

}