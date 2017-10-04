package com.playtika.thirdLesson.HomeWork3;

import com.playtika.second.HomeWork2.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileAndTextReader {
    private String dyrectoryName;


    public FileAndTextReader(String dyrectoryName) {
        this.dyrectoryName = dyrectoryName;
    }

    public void textReadResultAndFilesData() throws IOException {
        File myFolder = new File(dyrectoryName);
        File[] files = myFolder.listFiles();

        for (int i = 0; i < files.length; i++) {
            File fileData = new File(files[i].toString());

            System.out.println(new Text(read(files[i].toString())).getWordsFrequencies());
            System.out.printf("File path: %s; File size: %d; File creation date: %s%n", fileData.getPath(), fileData.length(), getCreationDateTime(fileData));
        }

    }

    private String read(String fileName) throws FileNotFoundException {
        if (fileName == null) {
            throw new NullPointerException("File sourse name can't be NULL");
        }

        StringBuilder fileStringBuilder = new StringBuilder();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String outputString;
                while ((outputString = inputFile.readLine()) != null) {
                    fileStringBuilder.append(outputString);
                    fileStringBuilder.append("\n");
                }
            } finally {
                inputFile.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileStringBuilder.toString();
    }

    private LocalDateTime getCreationDateTime(File file) throws IOException {

        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        return attr.creationTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
