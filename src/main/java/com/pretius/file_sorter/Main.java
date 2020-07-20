package com.pretius.file_sorter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.pretius.file_sorter.Directory.*;

class Main {

    public static void main(String[] args) {
        createDirectories();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(Main::run, 0, 2, TimeUnit.SECONDS);
    }

    private static void run() {
        FileSorter.sort();
    }

    private static void createDirectories() {
        try {
            FileUtils.forceMkdir(new File(HOME.name()));
            FileUtils.forceMkdir(new File(DEV.name()));
            FileUtils.forceMkdir(new File(TEST.name()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
