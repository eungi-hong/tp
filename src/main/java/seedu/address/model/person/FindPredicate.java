package seedu.address.model.person;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Tests that a {@code Person}'s {@code Name} matches all of the keywords given.
 */
public class FindPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public FindPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .allMatch(keyword -> testPerson(person, keyword)
                        || testTags(person.getTags(), keyword)
                        || testPets(person.getPets(), keyword));
    }

    private boolean testPerson(Person person, String keyword) {
        return StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword)
                || StringUtil.containsWordIgnoreCase(person.getPhone().value, keyword)
                || StringUtil.containsWordIgnoreCase(person.getEmail().value, keyword)
                || StringUtil.containsWordIgnoreCase(person.getAddress().value, keyword);
    }

    private boolean testTags(Collection<Tag> tags, String keyword) {
        return tags.stream()
                .anyMatch(tag -> StringUtil.containsWordIgnoreCase(tag.tagName, keyword));
    }

    private boolean testPets(Collection<Pet> pets, String keyword) {
        return pets.stream()
                .anyMatch(pet -> StringUtil.containsWordIgnoreCase(pet.getName().fullName, keyword)
                        || StringUtil.containsWordIgnoreCase(pet.getSpecies().fullName, keyword)
                        || StringUtil.containsWordIgnoreCase(pet.getBreed().fullName, keyword)
                        || StringUtil.containsWordIgnoreCase(pet.getNote().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindPredicate)) {
            return false;
        }

        FindPredicate otherNameContainsKeywordsPredicate = (FindPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
