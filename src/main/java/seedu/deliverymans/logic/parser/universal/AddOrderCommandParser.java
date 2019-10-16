package seedu.deliverymans.logic.parser.universal;

import static java.util.Objects.requireNonNull;
import static seedu.deliverymans.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.deliverymans.logic.commands.universal.AddOrderCommand.MESSAGE_ADD_ORDER_USAGE;
import static seedu.deliverymans.logic.parser.CliSyntax.PREFIX_CUSTOMER;
import static seedu.deliverymans.logic.parser.CliSyntax.PREFIX_DELIVERYMAN;
import static seedu.deliverymans.logic.parser.CliSyntax.PREFIX_ORDER;
import static seedu.deliverymans.logic.parser.CliSyntax.PREFIX_RESTAURANT;

import seedu.deliverymans.logic.commands.universal.AddOrderCommand;
import seedu.deliverymans.logic.parser.ArgumentMultimap;
import seedu.deliverymans.logic.parser.ArgumentTokenizer;
import seedu.deliverymans.logic.parser.Parser;
import seedu.deliverymans.logic.parser.exceptions.ParseException;
import seedu.deliverymans.model.order.Order;

/**
 * Parses input arguments and creates a new {@code OrderCommand} object
 */
public class AddOrderCommandParser implements Parser<AddOrderCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code OrderCommand}
     * and returns a {@code OrderCommand} object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddOrderCommand parse(String args) throws ParseException {
        String orderName;
        String customer;
        String restaurant;
        String deliveryman;

        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_ORDER, PREFIX_CUSTOMER,
                PREFIX_RESTAURANT, PREFIX_DELIVERYMAN);

        try {
            orderName = argMultimap.getValue(PREFIX_ORDER).orElse("");
            customer = argMultimap.getValue(PREFIX_CUSTOMER).orElseThrow(Exception::new);
            restaurant = argMultimap.getValue(PREFIX_RESTAURANT).orElseThrow(Exception::new);
            deliveryman = argMultimap.getValue(PREFIX_DELIVERYMAN).orElseThrow(Exception::new);
        } catch (Exception ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    MESSAGE_ADD_ORDER_USAGE));
        }

        Order order = new Order(orderName, customer, restaurant, deliveryman);
        return new AddOrderCommand(order);
    }
}
