import java.util.ArrayList;

public class RemoveLastCommand extends UndoCommand {
    private ArrayList<String> sourceList;
    
    public RemoveLastCommand(ArrayList<String> lst) {
        this.sourceList = lst;
    }
    
    @Override
    public void execute() {
        if (!sourceList.isEmpty()) {
            int lastIndex = sourceList.size() - 1;
            sourceList.remove(lastIndex);
        }
    }
}
