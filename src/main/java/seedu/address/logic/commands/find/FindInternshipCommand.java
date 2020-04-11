package seedu.address.logic.commands.find;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.results.CommandResult;
import seedu.address.logic.commands.results.FindCommandResult;
import seedu.address.model.Model;
import seedu.address.model.item.field.NameContainsKeywordsPredicate;

/**
 * Finds {@code Internship} items in the resume book whose name contains the keyword.
 * Keyword matching is case-insensitive.
 */
public class FindInternshipCommand extends FindCommand {
    public FindInternshipCommand(NameContainsKeywordsPredicate predicate) {
        super(predicate);
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setInternshipToDisplay();
        model.updateFilteredItemList(predicate);
        return new FindCommandResult("",
                String.format(Messages.MESSAGE_ITEMS_LISTED, model.getFilteredItemList().size(), "Internships"),
                model.getDisplayType());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindInternshipCommand // instanceof handles nulls
                && predicate.equals(((FindInternshipCommand) other).predicate)); // state check
    }
}
