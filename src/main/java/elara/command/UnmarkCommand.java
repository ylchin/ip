package elara.command;

import elara.storage.Storage;
import elara.task.InvalidInputException;
import elara.task.TaskList;
import elara.ui.Ui;

public class UnmarkCommand implements Command {
    private final String fullInput;

    public UnmarkCommand(String fullInput) {
        this.fullInput = fullInput;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws InvalidInputException {
        if (fullInput.trim().equals("mark")) {
            throw new InvalidInputException("Append task index after command!");
        }

        int i = Integer.parseInt(fullInput.split(" ", 2)[1]) - 1;
        if (i < 0 || i >= taskList.getTasks().size()) {
            throw new InvalidInputException("Task index out of bounds!");
        }
        taskList.unmarkTask(i);
        ui.showUnmarkedTaskMessage(taskList.getTask(i));
        storage.write(taskList);
    }
}
