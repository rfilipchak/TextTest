package com.playtika.thirdLesson.HomeWork3;

import java.io.*;


public class WorkWithFiles {
    public static void main(String[] args) throws IOException {
        String fileFirst = "D:\\JavaCourses\\FilesForTests\\text1.txt";
        String fileSecond = "D:\\JavaCourses\\FilesForTests\\text2.txt";
        String fileCopySecond = "D:\\JavaCourses\\FilesForTests\\fileCopySecond.txt";
        String directory = "D:\\JavaCourses\\FilesForTests\\";



        new FileAndTextReader(directory).filesFromDirectoryData();
        System.out.println(new FileAndTextReader(directory).agreateadGetWordsFrequenciesForDirectoriesFiles());

        new FilesCopyClass(fileSecond, fileCopySecond).fileCopyFromSourseToDestination();



    }


}
