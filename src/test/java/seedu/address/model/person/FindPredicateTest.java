package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.PetBuilder;

public class FindPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        FindPredicate firstPredicate = new FindPredicate(firstPredicateKeywordList);
        FindPredicate secondPredicate = new FindPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        FindPredicate firstPredicateCopy = new FindPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_containsKeywords_returnsTrue() {
        // Partially matching client name
        FindPredicate predicate = new FindPredicate(Arrays.asList("ALICE", "ceB", "Bob"));
        assertTrue(predicate.test(new PersonBuilder().withName("AliceBob").build()));

        // Fully matching client name and pet name
        predicate = new FindPredicate(Arrays.asList("Alice", "WooF"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice")
                .withPet(new PetBuilder().withName("Woof").build())
                .build()));

        // Partially matching client phone and client tag
        predicate = new FindPredicate(Arrays.asList("Ali", "WOO"));
        assertTrue(predicate.test(new PersonBuilder()
                .withPhone("AliceBob")
                .withTags("Woof").build()));

        // Partially matching client email and pet species
        predicate = new FindPredicate(Arrays.asList("AlicE", "dog"));
        assertTrue(predicate.test(new PersonBuilder().withEmail("AliceBob@aa.com")
                .withPet(new PetBuilder().withSpecies("doggy").build())
                .build()));

        // Partially matching client address and pet breed
        predicate = new FindPredicate(Arrays.asList("AlicE", "persian"));
        assertTrue(predicate.test(new PersonBuilder().withAddress("AliceBob")
                .withPet(new PetBuilder().withBreed("Persiane").build())
                .build()));

        // Partially matching pet breed and pet note
        predicate = new FindPredicate(Arrays.asList("AlicE", "persian"));
        assertTrue(predicate.test(new PersonBuilder()
                .withPet(new PetBuilder()
                        .withBreed("Persian")
                        .withNote("alicee").build())
                .build()));

        // Mixed-case keywords
        predicate = new FindPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_doesNotContainKeywords_returnsFalse() {
        // Non-matching keyword
        FindPredicate predicate = new FindPredicate(Arrays.asList("Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Only one matching keyword
        predicate = new FindPredicate(Arrays.asList("Bob", "Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Carol")
                .withPet(new PetBuilder().withBreed("Persian").build())
                .build()));

        // Separated keyword
        predicate = new FindPredicate(Arrays.asList("Bob"));
        assertFalse(predicate.test(new PersonBuilder()
                .withPet(new PetBuilder().withNote("Boab").build())
                .build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        FindPredicate predicate = new FindPredicate(keywords);

        String expected = FindPredicate.class.getCanonicalName() + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
