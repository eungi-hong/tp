package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PhotoPathTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PhotoPath(null));
    }

    @Test
    public void constructor_invalidPhotoPath_throwsIllegalArgumentException() {
        String invalidPhotoPath = "";
        assertThrows(IllegalArgumentException.class, () -> new PhotoPath(invalidPhotoPath));
    }

    @Test
    public void isValidPhotoPath() {
        // null photo path
        assertFalse(PhotoPath.isValidPhotoPath(null));

        // invalid photo path
        assertFalse(PhotoPath.isValidPhotoPath("")); // empty string
        assertFalse(PhotoPath.isValidPhotoPath("  ")); // spaces only
        assertFalse(PhotoPath.isValidPhotoPath(" ^")); // starts with space

        // non-existing file path
        assertFalse(PhotoPath.isValidPhotoPath("/images/non_existing_image.png"));

        // valid file path but does not exist
        assertFalse(PhotoPath.isValidPhotoPath("images/address_book_32.png"));

        // valid photo path
        assertTrue(PhotoPath.isValidPhotoPath("/images/placeholder-pet-logo.png"));
    }

    @Test
    public void equals() {
        PhotoPath photoPath = new PhotoPath("/images/placeholder-pet-logo.png");

        // same values -> returns true
        assertTrue(photoPath.equals(new PhotoPath("/images/placeholder-pet-logo.png")));

        // same object -> returns true
        assertTrue(photoPath.equals(photoPath));

        // null -> returns false
        assertFalse(photoPath.equals(null));

        // different types -> returns false
        assertFalse(photoPath.equals(5.0f));

        // different values -> returns false
        assertFalse(photoPath.equals(new PhotoPath("/images/clock.png")));
    }
}
