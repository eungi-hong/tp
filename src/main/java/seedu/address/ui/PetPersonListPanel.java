package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Pet;

/**
 * Panel containing the list of persons.
 */
public class PetPersonListPanel extends UiPart<Region> {
    private static final String FXML = "PetPersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PetPersonListPanel.class);

    @FXML
    private ListView<Person> petPersonListView;

    /**
     * Creates a {@code PetPersonListPanel} with the given {@code ObservableList}.
     */
    public PetPersonListPanel(ObservableList<Person> personList) {
        super(FXML);
        petPersonListView.setItems(personList);
        petPersonListView.setCellFactory(listView -> new PetPersonListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Pet} and {@code Person} using
     * a {@code PetPersonCard}.
     */
    class PetPersonListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                if (person.getPets().isEmpty()) {
                    Pet noPet = new Pet(new Name("No pets for this person"));
                    setGraphic(new PetPersonCard(noPet, person, getIndex() + 1).getRoot());
                } else {
                    Pet firstPet = person.getPets().iterator().next();
                    setGraphic(new PetPersonCard(firstPet, person, getIndex() + 1).getRoot());
                }
            }
        }
    }

}
