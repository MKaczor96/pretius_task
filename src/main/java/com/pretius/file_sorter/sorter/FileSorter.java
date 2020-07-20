package com.pretius.file_sorter.sorter;

import com.pretius.file_sorter.enums.Directory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.List;

public class FileSorter {

    private FileSorter() {

    }

    private static final List<String> EXTENTIONS_TO_SORT = List.of("jar", "xml");

    public static void sort() {
        FileUtils.listFiles(new File(Directory.HOME.name()), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE).stream()
                    .filter(file -> EXTENTIONS_TO_SORT.contains(FilenameUtils.getExtension(file.getName())))
                    .forEach(FileSorterExecutor::execute);
    }
}
