package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
<<<<<<< HEAD
=======
import static seedu.address.logic.parser.CliSyntax.PLACEHOLDER_IMAGE_PATH;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.stream.Stream;
>>>>>>> upstream/master

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeletePetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
<<<<<<< HEAD
=======
import seedu.address.model.person.Name;
import seedu.address.model.person.Pet;
import seedu.address.model.person.Phone;
import seedu.address.model.person.PhotoPath;
>>>>>>> upstream/master

/**
 * Parses input arguments and creates a new DeletePetCommand object
 */
public class DeletePetCommandParser implements Parser<DeletePetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the
     * DeletePetCommand
     * and returns a DeletePetCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeletePetCommand parse(String args) throws ParseException {
<<<<<<< HEAD
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeletePetCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            DeletePetCommand.MESSAGE_INDEX_TOO_SMALL), pe);
        }
=======
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_PHONE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeletePetCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE);
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());

        Pet pet = new Pet(name, new Name("dummy species"), new Name("dummy breed"), new Name("dummmy grooming notes"),
                new PhotoPath(PLACEHOLDER_IMAGE_PATH));

        return new DeletePetCommand(pet, phone);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values
     * in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
>>>>>>> upstream/master
    }
}
