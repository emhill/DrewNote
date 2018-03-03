package edu.drew.note;

public class HashedDict implements NoteCollection {
    private Note[] hashTable;

    // Prime to ensure even distribution of hashes.
    private static final int DEFAULT_CAPACITY = 1009;
    private int numberOfEntries;

    public HashedDict() {
        this(DEFAULT_CAPACITY);
    }

    public HashedDict(int capacity) {
        // Capacity should be prime to prevent collisions.
        hashTable = new Note[capacity];
        numberOfEntries = 0;
    }

    //Adds new entry to the collection.
    public boolean add(Note newNote) {
        // O(1)
        /*
        If the array is full or the newNote is null, return false.
        This implementation does not include collision resolution. Once
        the hash table is full, entries must be removed.
         */
        if (!checkCapacity() || newNote == null) {
            return false;
        }
        // Get the hash code for the new note.
        int newHash = hashID(newNote.getID());
        hashTable[newHash] = newNote;
        numberOfEntries++;
        return true;
    }

    // Returns a specific note by its id
    public Note lookup(long ID) {
        // O(1)
        int hash = hashID(ID);
        return hashTable[hash];
    }

    // Removes a specific note by its id
    public boolean remove(long ID) {
        // O(1)
        int hash = hashID(ID);
        if (hashTable[hash] == null) {
            return false;
        }
        // Set the removed note's location to null.
        hashTable[hash] = null;
        numberOfEntries--;
        return true;
    }

    // Removes a note by its object
    public boolean remove(Note note) {
        // O(1)
        if (numberOfEntries == 0) {
            return false;
        }
        else if (note == null) {
            return false;
        }
        int hash = hashID(note.getID());
        if (hashTable[hash] == null) {
            return false;
        }
        hashTable[hash] = null;
        numberOfEntries--;
        return true;
    }

    //Checks to see whether the collection is empty.
    //returns true if it is, and false if otherwise.
    public boolean isEmpty() {
        // O(1)
        return numberOfEntries == 0;
    }

    //Returns the size of the note collection.
    public int getSize() {
        // O(1)
        return numberOfEntries;
    }

    //sees whether anEntry is in the collection.
    public boolean contains(Note note) {
        // This method is O(1).
        int hash = hashID(note.getID());
        return hashTable[hash] != null;
    }

    public boolean contains(long ID) {
        // This method is O(1).
        int hash = hashID(ID);
        return hashTable[hash] != null;
    }

    // Returns an array of Notes
    public Note[] toArray() {
        /*
        Because this method iterates over the whole hash table,
        it's running time is O(n).
         */
        Note[] notesArray = new Note[numberOfEntries];
        int notesIndex = 0;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                continue;
            }
            notesArray[notesIndex] = hashTable[i];
            notesIndex++;
        }
        return notesArray;
    }

    // Hash the notes ID
    private int hashID(long ID) {
        /*
         The hash will be the notes ID modulo the length of the table.
         This will cause hashes to loop around once the hashes reach the
         end of the hash table. It's running time is O(1).
          */
        return (int) ID % hashTable.length;
    }

    private boolean checkCapacity() {
        // Return true if there is room left in the hash table.
        // This method is O(1).
        return numberOfEntries != hashTable.length;
    }
}
