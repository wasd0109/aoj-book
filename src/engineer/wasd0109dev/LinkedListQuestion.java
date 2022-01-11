package engineer.wasd0109dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListQuestion {

    public static void main(String[] args) throws IOException {
        class Item {
            private final int value;
            private int prevIndex;
            private final int index;
            private int nextIndex;

            public Item(int value, int index, int prevIndex, int nextIndex) {
                this.value = value;
                this.index = index;
                this.prevIndex = prevIndex;
                this.nextIndex = nextIndex;
            }

            public int getValue() {
                return value;
            }

            public int getPrevIndex() {
                return prevIndex;
            }

            public int getNextIndex() {
                return nextIndex;
            }

            public int getIndex() {
                return index;
            }

            public void setPrevIndex(int prevIndex) {
                this.prevIndex = prevIndex;
            }

            public void setNextIndex(int nextIndex) {
                this.nextIndex = nextIndex;
            }
        }
        class LinkedList {
            final Item[] list;
            private int startIndex = 0;
            private int endIndex = 0;
            private int counter = 0;
            private int currentIndex = startIndex;

            public LinkedList(int n) {
                this.list = new Item[n];
            }

            public Item getNext() {
                return this.list[currentIndex++];
            }

            public Item getPrevious() {
                return this.list[currentIndex--];
            }

            private void reset() {
                this.counter = 0;
                this.startIndex = 0;
                this.endIndex = 0;
            }

            public void insert(int x) {
                if (!this.isEmpty()) {
                    Item currentFirst = list[this.startIndex];
                    Item currentLast = list[this.endIndex];
                    Item newItem = new Item(x, counter, this.endIndex, currentFirst.getIndex());
                    this.list[counter] = newItem;
                    this.startIndex = counter;
                    currentLast.setNextIndex(this.startIndex);
                    currentFirst.setPrevIndex(this.startIndex);
                } else {
                    Item newItem = new Item(x, counter, this.endIndex, this.startIndex);
                    list[counter] = newItem;
                }
                counter++;
            }

            public boolean isEmpty() {
                return this.counter == this.startIndex && this.counter == this.endIndex;
            }

            public void delete(int x) {
                int index = this.startIndex;
                do {
                    Item item = list[index];
                    if (item.getValue() == x) {
                        Item prevItem = list[item.getPrevIndex()];
                        Item nextItem = list[item.getNextIndex()];
                        prevItem.setNextIndex(nextItem.getIndex());
                        nextItem.setPrevIndex(prevItem.getIndex());
                        if (index == this.startIndex) {
                            this.startIndex = nextItem.getIndex();
                        }
                        if (index == this.endIndex) {
                            this.endIndex = prevItem.getIndex();
                        }
                        break;
                    }
                    index = item.getNextIndex();
                } while (index != this.startIndex);

            }


            public void deleteFirst() {
                Item firstItem = list[startIndex];
                Item secondItem = list[firstItem.getNextIndex()];
                Item lastItem = list[endIndex];
                this.startIndex = firstItem.getNextIndex();
                if (firstItem == lastItem) {
                    this.reset();
                } else {
                    secondItem.setPrevIndex(endIndex);
                    lastItem.setNextIndex(this.startIndex);
                }
            }

            public void deleteLast() {
                Item lastItem = list[endIndex];
                Item secondLastItem = list[lastItem.getPrevIndex()];
                Item firstItem = list[startIndex];
                this.endIndex = lastItem.getPrevIndex();
                if (firstItem == lastItem) {
                    this.reset();
                } else {
                    secondLastItem.setNextIndex(this.startIndex);
                    firstItem.setPrevIndex(this.endIndex);
                }
            }

            public void printItem() {
                if (!this.isEmpty()) {
                    StringBuilder outputStr = new StringBuilder();
                    Item firstItem = list[this.startIndex];
                    outputStr.append(firstItem.getValue());
                    int nextIndex = firstItem.getNextIndex();
                    while (nextIndex != this.startIndex) {
                        Item nextItem = list[nextIndex];
                        outputStr.append(" ");
                        outputStr.append(nextItem.getValue());
                        nextIndex = nextItem.getNextIndex();
                    }
                    System.out.println(outputStr);
                }
            }
        }


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String numOfOpsLine = br.readLine();
            int numOfOps = Integer.parseInt(numOfOpsLine);
            LinkedList list = new LinkedList(numOfOps);
            int counter = 0;
            while (counter < numOfOps) {
                String[] inputArray = br.readLine().split(" ");
                String operation = inputArray[0];
                switch (operation) {
                    case "insert":
                        list.insert(Integer.parseInt(inputArray[1]));
                        break;
                    case "delete":
                        list.delete(Integer.parseInt(inputArray[1]));
                        break;
                    case "deleteFirst":
                        list.deleteFirst();
                        break;
                    case "deleteLast":
                        list.deleteLast();
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                counter++;
            }

            list.printItem();
        }

    }

}
