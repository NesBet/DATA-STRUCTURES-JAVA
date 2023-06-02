import java.util.ArrayList;

public class InsertAtCommand extends UndoCommand {
    private ArrayList<String> sourceList;
    private int insertIndex;
    private String item;
    
    public InsertAtCommand(ArrayList<String> lst, int idx, String itm) {
        this.sourceList = lst;
        this.insertIndex = idx;
        this.item = itm;
    }
    
    @Override
    public void execute() {
        if (isValidIndex(insertIndex)) {
            sourceList.add(insertIndex, item);
        }
    }
    
    private boolean isValidIndex(int index) {
        return index >= 0 && index <= sourceList.size();
    }
}
