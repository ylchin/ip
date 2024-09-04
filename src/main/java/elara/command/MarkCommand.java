import elara.task.TaskList;

public class MarkCommand implements Command {
    private final String taskDetails;

    public MarkCommand(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int i = Integer.parseInt(taskDetails) - 1;
        taskList.markTask(i);
        ui.showMarkedTaskMessage(taskList.getTask(i));
        storage.write(taskList);
    }
}
