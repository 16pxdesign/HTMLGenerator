package com.company.Control;

import com.company.Views.Page;
import com.company.Views.PageBuilder;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Test class to test Init class functionality
 * @see Init
 */
public class InitTest {

    /**
     * Method test is Page is saved on local drive
     */
    @Test
    public void testSaveAllPages() {
        Init init = new Init();
        Page build = init.generateIndexHTML();
        ArrayList<Page> objects = new ArrayList<>();
        objects.add(build);
        init.saveAllPages(objects);

        File tmpDir = new File("D:/" + build.getFilename());
        boolean exists = tmpDir.exists();
        assertTrue(exists);
    }
}