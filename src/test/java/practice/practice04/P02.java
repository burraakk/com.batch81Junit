package practice.practice04;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {
    //Verify that we have pom.xml file in our project => please try in 4 min s

    @Test
    public void test1() {
        String pomFilePath = "C:\\Users\\burak\\IdeaProjects\\com.batch81JUnit\\pom.xml";  //absolute path
        Assert.assertTrue(Files.exists(Paths.get(pomFilePath)));
    }

    @Test
    public void test2() {
        File pomFile = new File("C:\\Users\\burak\\IdeaProjects\\com.batch81JUnit\\pom.xml");
        assert  !pomFile.isHidden();
    }

    @Test
    public void test3() throws FileNotFoundException {
        String pomFilePath = "pom.xml";  // root path
        FileInputStream fis = new FileInputStream(pomFilePath);
        Assert.assertNotNull(fis);
    }
}
