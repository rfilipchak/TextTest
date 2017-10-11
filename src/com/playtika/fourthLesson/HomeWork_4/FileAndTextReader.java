package com.playtika.fourthLesson.HomeWork_4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileAndTextReader {
    private final String dyrectoryName;

    public FileAndTextReader(String dyrectoryName) throws IOException {
        this.dyrectoryName = dyrectoryName;
    }

    public void filesFromDirectoryData() throws IOException {
        Arrays.stream(new File(dyrectoryName).listFiles()).forEach(file -> {
            try {
                System.out.printf("File path: %s; File size: %d; File creation date: %s%n",
                        file.getPath(), file.length(), getCreationDateTime(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public Map<String, Long> agreateadGetWordsFrequenciesForDirectoriesFiles() throws IOException {
        return Files.list(Paths.get(dyrectoryName)).map(path -> readFileToStringLine(path))
                .flatMap(Collection::stream)
                .map(s -> s.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(w -> w.matches("([a-zA-Z0-9а-яА-Я]+)"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<String> readFileToStringLine(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private LocalDateTime getCreationDateTime(File file) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        return attr.creationTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
