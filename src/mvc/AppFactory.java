package mvc;

public interface AppFactory {
    Model makeModel();
    String[] getEditCommands();
    Command makeEditCommand(Model model, String cmmd);
    String getTitle();
    String about();
    String[] getHelp();
}
