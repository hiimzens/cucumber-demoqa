package com.demoqa.data_providers;

import java.io.File;

import static com.demoqa.constants.FilePathConstants.STUDENT_IMG_PATH;

public class StudentData {
    static File studentImagePath = new File(STUDENT_IMG_PATH);
    public static String studentImageAsbPath = studentImagePath.getAbsolutePath();
}
