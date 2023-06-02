import java.util.ArrayList;

public class SwapCommand extends UndoCommand {
    private ArrayList<String> sourceList;
    private int index1;
    private int index2;
    
    public SwapCommand(ArrayList<String> lst, int idx1, int idx2) {
        this.sourceList = lst;
        this.index1 = idx1;
        this.index2 = idx2;
    }
    
    @Override
    public void execute() {
        if (isValidIndex(index1) && isValidIndex(index2)) {
            String temp = sourceList.get(index1);
            sourceList.set(index1, sourceList.get(index2));
            sourceList.set(index2, temp);
        }
    }
    
    private boolean isValidIndex(int index) {
        return index >= 0 && index < sourceList.size();
    }
}
