package ru.indivio.homecrm.mapers;

import ru.indivio.homecrm.entities.Note;

import java.util.HashMap;
import java.util.Map;

public class IdentityNoteMap {

    private static Map<Integer, Note> noteHashMap = new HashMap<>();

    public IdentityNoteMap () {
    }

    public static Note getNote(int key) {
        return noteHashMap.get(key);
    }

    public static void addNote(Note note) {
        Integer key = note.getId();
        noteHashMap.put(key, note);
        System.out.println("Объект Note с key=" +key+" добавлен в IdentityMap");
    }
    public static void deleteNote(int key) {
        noteHashMap.remove(key);
        System.out.println("Объект NOte с key=" +key+" Удален из IdentityMap");

    }
}