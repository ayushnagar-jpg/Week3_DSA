package LinkedList.UndoRedoFunctionalityforTextEditor;

class TextNode {
    String text;
    TextNode prev, next;
    
    public TextNode(String text) {
        this.text = text;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextNode current;
    private int historySize = 10;
    private int count = 0;

    public TextEditor() {
        current = new TextNode(""); // Initial empty state
    }

    // Add a new state
    public void addState(String text) {
        TextNode newNode = new TextNode(text);
        newNode.prev = current;
        if (current != null) {
            current.next = newNode;
        }
        current = newNode;
        count++;
        
        // Maintain history size
        if (count > historySize) {
            removeOldest();
        }
    }

    // Remove the oldest state to maintain history size
    private void removeOldest() {
        TextNode temp = current;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        if (temp.next != null) {
            temp.next.prev = null;
        }
        count--;
    }

    // Undo functionality
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        System.out.println("Current Text: " + current.text);
    }
}

public class TextEditorDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState(); // Hello World!
        
        editor.undo();
        editor.displayCurrentState(); // Hello World
        
        editor.undo();
        editor.displayCurrentState(); // Hello
        
        editor.redo();
        editor.displayCurrentState(); // Hello World
    }
}

