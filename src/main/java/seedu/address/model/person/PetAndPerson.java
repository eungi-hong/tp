package seedu.address.model.person;

import java.util.Objects;

/**
 * Represents a Pet and Person in the address book.
 * Guarantees: immutable;
 */
public class PetAndPerson {
    private final Pet pet;
    private final Person person;
    private final int petIndex;
    private final int personIndex;

    /**
     * Constructs a {@code PetAndPerson}.
     *
     * @param pet A valid Pet object.
     * @param person A valid Person object.
     * @param petIndex A valid integer determining the position of the Pet in the UI
     * @param personIndex A valid integer determining the position of the Person in the list
     */
    public PetAndPerson(Pet pet, Person person, int petIndex, int personIndex) {
        this.pet = pet;
        this.person = person;
        this.petIndex = petIndex;
        this.personIndex = personIndex;
    }

    public Pet getPet() {
        return pet;
    }

    public Person getPerson() {
        return person;
    }

    public int getPetIndex() {
        return petIndex;
    }

    public int getPersonIndex() {
        return personIndex;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PetAndPerson)) {
            return false;
        }

        PetAndPerson otherPetAndPerson = (PetAndPerson) other;
        return pet.equals(otherPetAndPerson.getPet())
                && person.equals(otherPetAndPerson.getPerson())
                && petIndex == otherPetAndPerson.getPetIndex()
                && personIndex == otherPetAndPerson.getPersonIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(pet, person, petIndex, personIndex);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return "[" + pet + ", " + person + "]";
    }
}
