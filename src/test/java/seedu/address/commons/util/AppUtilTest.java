package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.Assert.assertThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class AppUtilTest {

    @Test
    public void loadImage_existingImage() {
        assertNotNull(AppUtil.loadImage("/images/address_book_32.png"));
    }

    @Test
    public void loadImage_nullGiven_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> AppUtil.loadImage(null));
    }

    @Test
    public void loadImage_nonExistingImage_loadsFallbackImage() {
        assertNotNull(AppUtil.loadImage("/images/non_existing_image.png"));
    }

    @Test
    public void loadImage_validClasspathImage_success() {
        assertNotNull(AppUtil.loadImage("/images/placeholder-pet-logo.png"));
    }

    @Test
    public void loadImage_validFilePathImage_success() {
        String validFilePath = System.getProperty("user.dir") + "/src/main/resources/images/placeholder-pet-logo.png";
        assertNotNull(AppUtil.loadImage(validFilePath));
    }

    @Test
    public void loadImage_invalidFilePathImage_loadsFallbackImage() {
        String invalidFilePath = System.getProperty("user.dir") + "/src/main/resources/images/non_existing_image.png";
        assertNotNull(AppUtil.loadImage(invalidFilePath));
    }

    @Test
    public void checkArgument_true_nothingHappens() {
        AppUtil.checkArgument(true);
        AppUtil.checkArgument(true, "");
    }

    @Test
    public void checkArgument_falseWithoutErrorMessage_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> AppUtil.checkArgument(false));
    }

    @Test
    public void checkArgument_falseWithErrorMessage_throwsIllegalArgumentException() {
        String errorMessage = "error message";
        assertThrows(IllegalArgumentException.class, errorMessage, () -> AppUtil.checkArgument(false, errorMessage));
    }

    @Test
    public void loadImage_validFileSystemPath_loadsImageSuccessfully(@TempDir File tempDir) throws IOException {
        // Create a temporary image file in the temp directory
        File tempImage = new File(tempDir, "test-image.png");

        // Copy an existing image to the temporary file
        try (InputStream input = AppUtil.class.getResourceAsStream("/images/placeholder-pet-logo.png");
             FileOutputStream output = new FileOutputStream(tempImage)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        // Test with absolute path that doesn't start with "/" (Windows-style or relative path)
        String absolutePath = tempImage.getAbsolutePath();
        assertNotNull(AppUtil.loadImage(absolutePath));
    }

    @Test
    public void loadImage_classpathResources_loadSuccessfully() {
        // Classpath resources starting with "/" should load via getResourceAsStream
        assertNotNull(AppUtil.loadImage("/images/placeholder-pet-logo.png"));
        assertNotNull(AppUtil.loadImage("/images/address_book_32.png"));
    }

    @Test
    public void loadImage_fileSystemPaths_loadSuccessfully(@TempDir File tempDir) throws IOException {
        // Create a temporary image file
        File tempImage = new File(tempDir, "fs-test-image.png");
        try (InputStream input = AppUtil.class.getResourceAsStream("/images/placeholder-pet-logo.png");
             FileOutputStream output = new FileOutputStream(tempImage)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        // Filesystem path should not be mistaken for a classpath resource
        assertNotNull(AppUtil.loadImage(tempImage.getAbsolutePath()));
    }
}
