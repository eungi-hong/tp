package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_PET_BREED_LABRADOR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PET_NAME_DOGGY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PET_NAME_SNOOPY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PET_NOTE_CUTE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PET_NOTE_FRIENDLY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PET_SPECIES_DOG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.person.Pet;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPets {

    public static final Pet SNOOPY = new PetBuilder()
            .withName(VALID_PET_NAME_SNOOPY)
            .withSpecies(VALID_PET_SPECIES_DOG)
            .withBreed(VALID_PET_BREED_LABRADOR)
            .withNote(VALID_PET_NOTE_FRIENDLY)
            .build();
    public static final Pet DOGGY = new PetBuilder()
            .withName(VALID_PET_NAME_DOGGY)
            .withSpecies(VALID_PET_SPECIES_DOG)
            .withBreed(VALID_PET_BREED_LABRADOR)
            .withNote(VALID_PET_NOTE_CUTE)
            .build();
    public static final Pet BARKUS = new PetBuilder()
            .withName("Barkus")
            .withSpecies("Dog")
            .withBreed("Poodle")
            .withNote("Very energetic")
            .build();
    public static final Pet MEOWY = new PetBuilder()
            .withName("Meowy")
            .withSpecies("Cat")
            .withBreed("Siamese")
            .withNote("Very playful")
            .build();

    private TypicalPets() {} // prevents instantiation


    public static List<Pet> getTypicalPets() {
        return new ArrayList<>(Arrays.asList(SNOOPY, DOGGY));
    }
}
