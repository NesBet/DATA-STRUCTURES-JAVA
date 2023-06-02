import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.io.PrintWriter;

public class GroceryList {
    protected ArrayList<String> listItems = new ArrayList<String>();
    protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

    public void addWithUndo(String newItemName) {
        listItems.add(newItemName);
        undoStack.push(new RemoveLastCommand(listItems));
    }

    public void removeAtWithUndo(int removalIndex) {
        if (isValidIndex(removalIndex)) {
            String removedItem = listItems.remove(removalIndex);
            undoStack.push(new InsertAtCommand(listItems, removalIndex, removedItem));
        }
    }

    public void swapWithUndo(int index1, int index2) {
        if (isValidIndex(index1) && isValidIndex(index2)) {
            Collections.swap(listItems, index1, index2);
            undoStack.push(new SwapCommand(listItems, index1, index2));
        }
    }

    public void executeUndo() {
        if (!undoStack.isEmpty()) {
            UndoCommand undoCommand = undoStack.pop();
            undoCommand.execute();
        }
    }

    final int getListSize() {
        return listItems.size();
    }

    final int getUndoStackSize() {
        return undoStack.size();
    }

    final ArrayList<String> getVectorCopy() {
        return new ArrayList<String>(listItems);
    }

    public void print(PrintWriter outputStream) {
        for (int i = 0; i < listItems.size(); i++) {
            outputStream.write(i + ". " + listItems.get(i) + "\n");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < listItems.size();
    }
}
