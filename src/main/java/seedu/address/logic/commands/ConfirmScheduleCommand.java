package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.commons.util.CalendarUtil;
import seedu.address.commons.util.DateUtil;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.duty.DutyMonth;
import seedu.address.model.duty.DutyStorage;

public class ConfirmScheduleCommand extends Command {

    public static final String COMMAND_WORD = "confirmschedule";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "Confirms previously generated schedule\n";

    public static final String SCHEDULE_SUCCESS = "Schedule for %s %s confirmed! See below for details\n\n%s\n\n%s\n\n";
    public static final String SCHEDULE_ALREADY_CONFIRMED = "Schedule for %s %s already confirmed! See below for details\n\n%s\n\n%s\n\n";
    public static final String NO_SCHEDULE_YET = "No schedules found! Tye <schedule> to make a schedule!";

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);
        DutyMonth dutyMonth = model.getDutyCalendar().getNextMonth();
        DutyStorage dutyStorage = model.getDutyStorage();

        if (dutyMonth.getScheduledDuties() == null) {
            return new CommandResult(NO_SCHEDULE_YET);
        }

        if (dutyMonth.isConfirmed()) {
            return new CommandResult(String.format(SCHEDULE_ALREADY_CONFIRMED,
                    DateUtil.getMonth(dutyMonth.getMonthIndex()),
                    dutyMonth.getYear(),
                    dutyMonth.printDuties(),
                    dutyMonth.printPoints(dutyStorage)));
        }

        dutyStorage.update(dutyMonth.getScheduledDuties());
        dutyMonth.confirm();
        return new CommandResult(String.format(SCHEDULE_SUCCESS,
                DateUtil.getMonth(dutyMonth.getMonthIndex()),
                dutyMonth.getYear(),
                dutyMonth.printDuties(),
                dutyStorage.printPoints()));
    }

    @Override
    public CommandResult executeAdmin(Model model, CommandHistory commandHistory) throws CommandException {
        return execute(model, commandHistory);
    }

    @Override
    public CommandResult executeGeneral(Model model, CommandHistory commandHistory) throws CommandException {
        throw new CommandException(Messages.MESSAGE_NO_AUTHORITY);
    }
}
