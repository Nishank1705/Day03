class TextState {
    String content; // Text content of the editor
    TextState prev, next; // Pointers for undo/redo

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    TextState current; // Current state of the editor
    int historyLimit = 10; // Maximum history size

    // Add a new state (action) to the text editor
    public void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }

        current = newState; // Update the current state

        // Trim history if it exceeds the limit
        trimHistory();
        System.out.println("New state added: " + content);
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: Current state is \"" + current.content + "\"");
        } else {
            System.out.println("No further undo available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: Current state is \"" + current.content + "\"");
        } else {
            System.out.println("No further redo available.");
        }
    }

    // Display the current state of the editor
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    // Trim history to maintain the limit
    private void trimHistory() {
        int count = 0;
        TextState temp = current;

        // Count backward to find the limit
        while (temp != null) {
            count++;
            if (count > historyLimit) {
                temp.prev.next = null;
                temp.prev = null;
                break;
            }
            temp = temp.prev;
        }
    }
}

public class UndoRedoEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("State 1: Hello");
        editor.addState("State 2: Hello World");
        editor.addState("State 3: Hello World with waving  hand!");
        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("State 4: Goodbye World!");
        editor.displayCurrentState();
    }
}

