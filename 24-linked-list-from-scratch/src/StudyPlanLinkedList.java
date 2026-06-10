import java.util.ArrayList;

public class StudyPlanLinkedList {
    private CheckpointNode head;
    private CheckpointNode tail;
    private int size;

    public void addFirst(LearningCheckpoint checkpoint) {
        validateCheckpoint(checkpoint);
        CheckpointNode node = new CheckpointNode(checkpoint);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast(LearningCheckpoint checkpoint) {
        validateCheckpoint(checkpoint);
        CheckpointNode node = new CheckpointNode(checkpoint);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertAt(int index, LearningCheckpoint checkpoint) {
        validateCheckpoint(checkpoint);
        validateInsertIndex(index);
        if (index == 0) {
            addFirst(checkpoint);
            return;
        }
        if (index == size) {
            addLast(checkpoint);
            return;
        }

        CheckpointNode previous = nodeAt(index - 1);
        CheckpointNode node = new CheckpointNode(checkpoint);
        node.next = previous.next;
        previous.next = node;
        size++;
    }

    public LearningCheckpoint removeAt(int index) {
        validateElementIndex(index);
        if (index == 0) {
            LearningCheckpoint removed = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return removed;
        }

        CheckpointNode previous = nodeAt(index - 1);
        CheckpointNode removedNode = previous.next;
        previous.next = removedNode.next;
        if (removedNode == tail) {
            tail = previous;
        }
        size--;
        return removedNode.value;
    }

    public LearningCheckpoint get(int index) {
        validateElementIndex(index);
        return nodeAt(index).value;
    }

    public int indexOf(String title) {
        if (title == null) {
            return -1;
        }
        CheckpointNode current = head;
        int index = 0;
        while (current != null) {
            if (current.value.getTitle().equalsIgnoreCase(title)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int totalMinutes() {
        int total = 0;
        CheckpointNode current = head;
        while (current != null) {
            total += current.value.getEstimatedMinutes();
            current = current.next;
        }
        return total;
    }

    public int handsOnCount() {
        int count = 0;
        CheckpointNode current = head;
        while (current != null) {
            if (current.value.isHandsOn()) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public ArrayList<LearningCheckpoint> snapshot() {
        ArrayList<LearningCheckpoint> checkpoints = new ArrayList<LearningCheckpoint>();
        CheckpointNode current = head;
        while (current != null) {
            checkpoints.add(current.value);
            current = current.next;
        }
        return checkpoints;
    }

    private CheckpointNode nodeAt(int index) {
        CheckpointNode current = head;
        for (int step = 0; step < index; step++) {
            current = current.next;
        }
        return current;
    }

    private void validateCheckpoint(LearningCheckpoint checkpoint) {
        if (checkpoint == null) {
            throw new IllegalArgumentException("Checkpoint must not be null.");
        }
    }

    private void validateInsertIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Insert index out of range: " + index);
        }
    }

    private void validateElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Element index out of range: " + index);
        }
    }

    private static class CheckpointNode {
        private final LearningCheckpoint value;
        private CheckpointNode next;

        private CheckpointNode(LearningCheckpoint value) {
            this.value = value;
        }
    }
}
