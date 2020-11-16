package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.File;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    FileOpenManager manager = new FileOpenManager();

    private String fileExtensionPdf = ".pdf";
    private String fileExtensionJpg = ".jpg";
    private String fileExtensionPpt = ".ppt";

    private String applicationForPdf = "Adobe Acrobat Reader";
    private String applicationForJpg = "Microsoft Paint";
    private String applicationForPpt = "Microsoft PowerPoint";

    @BeforeEach
    public void setUp() {
        manager.files.put(fileExtensionPdf, applicationForPdf);
        manager.files.put(fileExtensionJpg, applicationForJpg);
        manager.files.put(fileExtensionPpt, applicationForPpt);
    }

    @Test
    public void shouldAddNewApplication() {
        String fileExtension = ".doc";
        String application = "Microsoft Word";

        Map<String, String> expected = Map.of(".doc", "Microsoft Word");
        Map<String, String> actual = manager.addNewApplication(fileExtension, application);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApplicationByFileExtensionIfExists() {
        String fileExtension = ".pdf";

        String expected = "Adobe Acrobat Reader";
        String actual = manager.getApplication(fileExtension);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotGetApplicationByFileExtensionIfNotExists() {
        String fileExtension = ".doc";

        String expected = null;
        String actual = manager.getApplication(fileExtension);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveApplicationBindingToExtensionIfExists() {
        String fileExtension = ".ppt";

        Map<String, String> expected = Map.of(fileExtensionPdf, applicationForPdf, fileExtensionJpg, applicationForJpg);
        Map<String, String> actual = manager.removeApplicationBindingToExtension(fileExtension);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveApplicationBindingToExtensionIfNotExists() {
        String fileExtension = ".doc";

        Map<String, String> expected = Map.of(fileExtensionPdf, applicationForPdf, fileExtensionJpg, applicationForJpg, fileExtensionPpt, applicationForPpt);
        Map<String, String> actual = manager.removeApplicationBindingToExtension(fileExtension);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetListOfAllRegisteredExtensions() {
        Set<String> expected = Set.of(fileExtensionJpg, fileExtensionPdf, fileExtensionPpt);
        Set<String> actual = manager.getListOfAllRegisteredExtensions();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetListOfAllApplicationsBindingToExtensions() {
        Set<String> expected = Set.of(applicationForPdf, applicationForJpg, applicationForPpt);
        Set<String> actual = manager.getListOfAllApplicationsBindingToExtensions();

        assertEquals(expected, actual);
    }
}