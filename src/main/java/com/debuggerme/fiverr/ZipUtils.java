package com.debuggerme.fiverr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZipUtils {
    public static void pack(String sourceDirPath, String zipFilePath) throws IOException {
        Path p = Files.createFile(Paths.get(zipFilePath, new String[0]), (FileAttribute<?>[]) new FileAttribute[0]);
        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p, new java.nio.file.OpenOption[0]))) {
            Path pp = Paths.get(sourceDirPath, new String[0]);
            Files.walk(pp, new java.nio.file.FileVisitOption[0])
                    .filter(path -> !Files.isDirectory(path, new java.nio.file.LinkOption[0]))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    });
        }
    }
}
