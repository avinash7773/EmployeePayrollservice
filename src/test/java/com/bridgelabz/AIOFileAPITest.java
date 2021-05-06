package com.bridgelabz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class AIOFileAPITest {
    private static String Home = System.getProperty("user.home");
    private static String play_with_AIO = "tempPlayGround";

    @Test
    void givenPathWhenCheckedThenConfirm() throws IOException {
        /**
         * check file exists
         */
        Path homePath = Paths.get(Home);
        Assert.assertTrue(Files.exists(homePath));

        /**
         * delete file and check file not exists
         */
        Path playPath = Paths.get(Home + "/" + play_with_AIO);
        if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

        /**
         * create directory
         */
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        /**
         * create files
         */
        IntStream.range(1,10).forEach(cntr -> { Path tempFile = Paths.get(playPath +"/temp"+cntr);
        Assert.assertTrue(Files.notExists(tempFile));
        try{
            Files.createFile(tempFile);
        }catch (IOException e){
            Assert.assertTrue(Files.exists(tempFile));
        }
        });

        /**
         * List Files, directories as well as files with extension
         */
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
                path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
