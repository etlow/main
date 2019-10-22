package seedu.deliverymans.model.util;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.deliverymans.model.Name;
import seedu.deliverymans.model.Phone;
import seedu.deliverymans.model.Tag;
import seedu.deliverymans.model.addressbook.AddressBook;
import seedu.deliverymans.model.addressbook.ReadOnlyAddressBook;
import seedu.deliverymans.model.addressbook.person.Person;
import seedu.deliverymans.model.addressbook.person.Remark;
import seedu.deliverymans.model.customer.Customer;
import seedu.deliverymans.model.database.CustomerDatabase;
import seedu.deliverymans.model.database.DeliverymenDatabase;
import seedu.deliverymans.model.database.OrderBook;
import seedu.deliverymans.model.database.ReadOnlyCustomerDatabase;
import seedu.deliverymans.model.database.ReadOnlyDeliverymenDatabase;
import seedu.deliverymans.model.database.ReadOnlyOrderBook;
import seedu.deliverymans.model.database.ReadOnlyRestaurantDatabase;
import seedu.deliverymans.model.database.RestaurantDatabase;
import seedu.deliverymans.model.deliveryman.Deliveryman;
import seedu.deliverymans.model.food.Food;
import seedu.deliverymans.model.location.LocationMap;
import seedu.deliverymans.model.order.Order;
import seedu.deliverymans.model.restaurant.Restaurant;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static final Remark EMPTY_REMARK = new Remark("");

    public static Person[] getSamplePersons() {
        return new Person[]{
        };
    }


    public static Customer[] getSampleCustomers() {
        return new Customer[]{
            new Customer(new Name("Alex Yeoh"), new Phone("87438807"), getTagSet("FastFood")),
            new Customer(new Name("Bernice Yu"), new Phone("99272758"), getTagSet("Indian")),
            new Customer(new Name("Charlotte Oliveiro"), new Phone("93210283"), getTagSet("Bar")),
            new Customer(new Name("David Li"), new Phone("91031282"), getTagSet("Japanese")),
            new Customer(new Name("Ifran Ibrahim"), new Phone("92492021"), getTagSet("Barbeque"))
        };
    }

    public static Restaurant[] getSampleRestaurants() {
        return new Restaurant[]{
            new Restaurant(new Name("KFC"), LocationMap.getLocation("Jurong").get(),
                    getTagSet("FastFood", "Western"),
                    getMenu(new Food(new Name("Ginger Burger"), new BigDecimal(6.5), Duration.ofSeconds(60)),
                            new Food(new Name("Shrooms Burger"), new BigDecimal(5), Duration.ofSeconds(60)),
                            new Food(new Name("Fish Fillet Burger"), new BigDecimal(5.5), Duration.ofSeconds(60)),
                            new Food(new Name("2 Piece Chicken"), new BigDecimal(7.95), Duration.ofSeconds(120)),
                            new Food(new Name("3 Piece Chicken"), new BigDecimal(10.95), Duration.ofSeconds(120)),
                            new Food(new Name("Chicken Nuggets"), new BigDecimal(3), Duration.ofSeconds(30)))),

            new Restaurant(new Name("Prata House"), LocationMap.getLocation("Bishan").get(),
                    getTagSet("Indian"),
                    getMenu(new Food(new Name("Plain Prata"), new BigDecimal(0.7), Duration.ofSeconds(60)),
                            new Food(new Name("Egg Prata"), new BigDecimal(1), Duration.ofSeconds(60)),
                            new Food(new Name("Cheese Prata"), new BigDecimal(1.2), Duration.ofSeconds(60)),
                            new Food(new Name("Prata Bomb"), new BigDecimal(2), Duration.ofSeconds(120)),
                            new Food(new Name("Curry Fountain"), new BigDecimal(2), Duration.ofSeconds(120)),
                            new Food(new Name("Curry Waterfall"), new BigDecimal(3), Duration.ofSeconds(120)))),

            new Restaurant(new Name("SkyBar Bar and Restaurant"), LocationMap.getLocation("Marina").get(),
                    getTagSet("Bar"),
                    getMenu(new Food(new Name("Duck Confit"), new BigDecimal(10), Duration.ofSeconds(300)),
                            new Food(new Name("Foie gras"), new BigDecimal(15), Duration.ofSeconds(300)),
                            new Food(new Name("Buffalo Wings"), new BigDecimal(15), Duration.ofSeconds(350)),
                            new Food(new Name("Rhinoceros Pizza"), new BigDecimal(25), Duration.ofSeconds(600)),
                            new Food(new Name("Hippo Teeth"), new BigDecimal(30.5), Duration.ofSeconds(120)),
                            new Food(new Name("Rat with Caviar"), new BigDecimal(49.9), Duration.ofSeconds(120)))),

            new Restaurant(new Name("IchiNiSan Ramen"), LocationMap.getLocation("City").get(),
                    getTagSet("Japanese"),
                    getMenu(new Food(new Name("Ramen A"), new BigDecimal(10), Duration.ofSeconds(300)),
                            new Food(new Name("Ramen B"), new BigDecimal(10), Duration.ofSeconds(300)),
                            new Food(new Name("Ramen C"), new BigDecimal(10), Duration.ofSeconds(300)),
                            new Food(new Name("Ramen D"), new BigDecimal(15), Duration.ofSeconds(300)),
                            new Food(new Name("Ramen E"), new BigDecimal(15), Duration.ofSeconds(300)),
                            new Food(new Name("Ramen F"), new BigDecimal(15), Duration.ofSeconds(300)))),

            new Restaurant(new Name("Piggys Self Barbeque"), LocationMap.getLocation("Woodlands").get(),
                    getTagSet("Barbeque"),
                    getMenu(new Food(new Name("BBQ Head"), new BigDecimal(10), Duration.ofSeconds(1000)),
                            new Food(new Name("BBQ Shank"), new BigDecimal(15), Duration.ofSeconds(600)),
                            new Food(new Name("BBQ Trotter"), new BigDecimal(15), Duration.ofSeconds(600)),
                            new Food(new Name("BBQ Nails"), new BigDecimal(25), Duration.ofSeconds(300)),
                            new Food(new Name("BBQ Butt"), new BigDecimal(30.5), Duration.ofSeconds(1200)),
                            new Food(new Name("BBQ Tail"), new BigDecimal(49.9), Duration.ofSeconds(300))))
        };
    }

    public static Order[] getSampleOrders() {
        return new Order[]{
            new Order("o1", "Alex Yeoh", "87438807", "friends"),
            new Order("o2", "Bernice Yu", "99272758", "berniceyu@example.com"),
            new Order("o3", "Charlotte Oliveiro", "93210283", "charlotte@example.com"),
            new Order("o4", "David Li", "91031282", "lidavid@example.com"),
            new Order("o5", "Irfan Ibrahim", "92492021", "irfan@example.com"),
            new Order("o6", "Roy Balakrishnan", "92624417", "royb@example.com")
        };
    }

    public static Deliveryman[] getSampleDeliverymen() {
        return new Deliveryman[]{
            new Deliveryman(new Name("Damith"), new Phone("99999999"), getTagSet("inactive")),
            new Deliveryman(new Name("Donald Trump"), new Phone("91234567"), getTagSet("buff", "powerful")),
            new Deliveryman(new Name("Charlie Choong"), new Phone("98887146"), getTagSet("active")),
            new Deliveryman(new Name("Low ee ter"), new Phone("99367862"), getTagSet("inactive")),
            new Deliveryman(new Name("Yuen Jun rong "), new Phone("12345678"), getTagSet("veryactive"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static ReadOnlyCustomerDatabase getSampleCustomerDatabase() {
        CustomerDatabase sampleCd = new CustomerDatabase();
        for (Customer sampleCustomer : getSampleCustomers()) {
            sampleCd.addCustomer(sampleCustomer);
        }
        return sampleCd;
    }

    public static ReadOnlyDeliverymenDatabase getSampleDeliverymenDatabase() {
        DeliverymenDatabase sampleDd = new DeliverymenDatabase();
        for (Deliveryman sampleDeliveryman: getSampleDeliverymen()) {
            sampleDd.addDeliveryman(sampleDeliveryman);
        }
        return sampleDd;
    }

    public static ReadOnlyRestaurantDatabase getSampleRestaurantDatabase() {
        RestaurantDatabase sampleRd = new RestaurantDatabase();
        for (Restaurant sampleRestaurant : getSampleRestaurants()) {
            sampleRd.addRestaurant(sampleRestaurant);
        }
        return sampleRd;
    }

    public static ReadOnlyOrderBook getSampleOrderBook() {
        OrderBook sampleOb = new OrderBook();
        for (Order sampleOrder : getSampleOrders()) {
            sampleOb.addOrder(sampleOrder);
        }
        return sampleOb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static ObservableList<Food> getMenu(Food... foods) {
        ObservableList<Food> menu = FXCollections.observableArrayList();
        menu.addAll(foods);
        return menu;
    }
}
