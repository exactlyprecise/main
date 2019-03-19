package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.PersonnelDatabase;
import seedu.address.model.person.Person;

import static seedu.address.logic.commands.CommandTestUtil.*;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withNric("S9673582K").withCompany("Leopard")
            .withSection("1").withRank("CFC").withName("Alice Pauline")
            .withPhone("94351253").withTags("outstanding").build();
    public static final Person BENSON = new PersonBuilder().withNric("S9478974B").withCompany("Hawk")
            .withSection("2").withRank("PTE").withName("Benson Meier")
            .withPhone("98765432").withTags("injured").build();
    public static final Person CARL = new PersonBuilder().withNric("S9324325I").withCompany("Cougar")
            .withSection("3").withRank("REC").withName("Carl Kurz")
            .withPhone("95352563").build();
    public static final Person DANIEL = new PersonBuilder().withNric("T0034567L").withCompany("Falcon")
            .withSection("4").withRank("LCP").withName("Daniel Meier")
            .withPhone("87652533").build();
    public static final Person ELLE = new PersonBuilder().withNric("S9876567I").withCompany("Ninja")
            .withSection("2").withRank("REC").withName("Elle Meyer")
            .withPhone("9482224").build();
    public static final Person FIONA = new PersonBuilder().withNric("S9357825I").withCompany("2nd")
            .withSection("1").withRank("PTE").withName("Fiona Kunz")
            .withPhone("9482427").build();
    public static final Person GEORGE = new PersonBuilder().withNric("T0065782J").withCompany("1st")
            .withSection("2").withRank("CFC").withName("George Best")
            .withPhone("+942442").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withNric("S1234567H").withCompany("Jaguar")
            .withSection("3").withRank("PTE").withName("Hoon Meier")
            .withPhone("8482424").build();
    public static final Person IDA = new PersonBuilder().withNric("S1234567I").withCompany("Mohawk")
            .withSection("3").withRank("LCP").withName("Ida Mueller")
            .withPhone("8482131").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withNric(VALID_NRIC_AMY).withCompany(VALID_COMPANY_AMY)
            .withSection(VALID_SECTION_AMY).withRank(VALID_RANK_AMY).withName(VALID_NAME_AMY)
            .withPhone(VALID_PHONE_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder().withNric(VALID_NRIC_BOB).withCompany(VALID_COMPANY_BOB)
            .withSection(VALID_SECTION_BOB).withRank(VALID_RANK_BOB).withName(VALID_NAME_BOB)
            .withPhone(VALID_PHONE_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code PersonnelDatabase} with all the typical persons.
     */
    public static PersonnelDatabase getTypicalPersonnelDatabase() {
        PersonnelDatabase ab = new PersonnelDatabase();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
