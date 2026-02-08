package org.example.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> contacts = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        contacts
                .computeIfAbsent(lastName, k -> new ArrayList<>())
                .add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, new ArrayList<>());
    }
}
