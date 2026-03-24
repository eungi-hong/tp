package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPets.BARKUS;
import static seedu.address.testutil.TypicalPets.DOGGY;
import static seedu.address.testutil.TypicalPets.MEOWY;
import static seedu.address.testutil.TypicalPets.SNOOPY;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PetBuilder;

public class PetTest {

    @Test
    public void equals() {
        // same values -> returns true
        Pet snoopyCopy = new PetBuilder(SNOOPY).build();
        assertTrue(SNOOPY.equals(snoopyCopy));

        // same object -> returns true
        assertTrue(SNOOPY.equals(SNOOPY));

        // null -> returns false
        assertFalse(SNOOPY.equals(null));

        // different type -> returns false
        assertFalse(SNOOPY.equals(5));

        // different name -> returns false
        assertFalse(SNOOPY.equals(DOGGY));

        // different name and breed -> returns false
        assertFalse(SNOOPY.equals(BARKUS));

        assertFalse(SNOOPY.equals(MEOWY));
    }

    @Test
    public void toStringMethod() {
        String expected = "[" + "Snoopy" + "]";
        assertEquals(expected, SNOOPY.toString());
    }
}
