package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Pet;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.PetBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code DeletePetCommand}.
 */
public class DeletePetCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPet_success() {
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());

        Person personInList = model.getAddressBook().getPersonList().get(0);
        Pet validPet = new PetBuilder().build();
        model.addPet(validPet, personInList.getPhone());

        assertCommandSuccess(new DeletePetCommand(validPet, personInList.getPhone()), model,
                String.format(DeletePetCommand.MESSAGE_SUCCESS, Messages.format(validPet)),
                expectedModel);
    }

    @Test
    public void execute_nonexistentPerson_throwsCommandException() {
        Person validPerson = new PersonBuilder().build();
        Pet validPet = new PetBuilder().build();

        assertCommandFailure(new DeletePetCommand(validPet, validPerson.getPhone()), model,
                DeletePetCommand.MESSAGE_NONEXISTENT_PERSON);
    }

    @Test
    public void execute_nonexistentPet_throwsCommandException() {
        Person personInList = model.getAddressBook().getPersonList().get(0);
        Pet validPet = new PetBuilder().build();

        assertCommandFailure(new DeletePetCommand(validPet, personInList.getPhone()), model,
                DeletePetCommand.MESSAGE_NONEXISTENT_PET);
    }

}
