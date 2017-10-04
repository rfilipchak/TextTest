package com.playtika.thirdLesson.HomeWork3;

import com.playtika.second.HomeWork2.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


public class WorkWithFiles {
    public static void main(String[] args) throws IOException {
        String fileFirst = "D:\\JavaCourses\\FilesForTests\\text1.txt";
        String fileSecond = "D:\\JavaCourses\\FilesForTests\\text2.txt";
        String fileCopySecond = "D:\\JavaCourses\\FilesForTests\\fileCopySecond.txt";
        String directory = "D:\\JavaCourses\\FilesForTests\\";




        new FilesCopyClass(fileFirst,"null").fileCopyFromSourseToDestination();



    }


}
