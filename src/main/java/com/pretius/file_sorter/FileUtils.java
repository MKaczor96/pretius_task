package com.pretius.file_sorter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

class FileUtils {

    private FileUtils() {

    }

    static void move(File source, File destination) {
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(source, destination, true);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    static int getCreationHour(File file) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("H");
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            return Integer.parseInt(dateFormat.format(attr.creationTime().toMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException();
    }
}
