package com.playtika.thirdLesson.HomeWork3;

import java.io.*;

public class FilesCopyClass {
    private String fileSourseName;
    private String fileDestinationName;

    public FilesCopyClass(String fileSourseName, String fileDestinationName) throws FileNotFoundException {

        if (fileSourseName == null) {
            throw new NullPointerException("File sourse name can't be NULL");
        } else if (fileSourseName.isEmpty()) {
            throw new FileNotFoundException("fileSourseName can't be empty");
        } else if (fileDestinationName == null) {
            throw new NullPointerException("File destination name can't be NULL");
        } else if (fileDestinationName.isEmpty()) {
            throw new FileNotFoundException("fileDestinationName can't be empty");
        }

        this.fileSourseName = fileSourseName;
        this.fileDestinationName = fileDestinationName;
    }

    public void fileCopyFromSourseToDestination() throws IOException {

        File fileSourse = new File(fileSourseName);
        if (!fileSourse.exists()) {
            throw new FileNotFoundException("Sourse file not found");
        }
        File fileDestination = new File(fileDestinationName);

        InputStream fileSourseIs = new FileInputStream(fileSourse);
        try {
            OutputStream fileDestOs = new FileOutputStream(fileDestination);
            try {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileSourseIs.read(buffer)) > 0) {
                    fileDestOs.write(buffer, 0, length);
                }
            } finally {
                fileDestOs.close();
            }
        }
        finally {
            fileSourseIs.close();
        }
        if (!fileDestination.exists()){
            throw new FileNotFoundException("Destination file not found");
        }


    }

}
