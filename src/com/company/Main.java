package com.company;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Collection<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Alex", "+380661234561"));
        contacts.add(new Contact("Dasha", "+380661234562"));
        contacts.add(new Contact("Oleg", "+380661234563"));
        contacts.add(new Contact("Ira", "+380661234564"));
        contacts.add(new Contact("Maks", "+380661234565"));
        contacts.add(new Contact("Misha", "+380661234566"));

        List<CallLog> callLogs = new ArrayList<>();
        callLogs.add(new CallLog("+380661234561", 120, new Date()));
        callLogs.add(new CallLog("+380661234561", 2320, new Date()));
        callLogs.add(new CallLog("+380661234561", 1120, new Date()));
        callLogs.add(new CallLog("+380661234561", 70, new Date()));
        callLogs.add(new CallLog("+380661234562", 6420, new Date()));
        callLogs.add(new CallLog("+380661234562", 10, new Date()));
        callLogs.add(new CallLog("+380661234563", 1720, new Date()));
        callLogs.add(new CallLog("+380661234564", 50, new Date()));
        callLogs.add(new CallLog("+380661234564", 65, new Date()));
        callLogs.add(new CallLog("+380661234564", 720, new Date()));
        callLogs.add(new CallLog("+380661234565", 920, new Date()));
        callLogs.add(new CallLog("+380661234565", 63, new Date()));
        callLogs.add(new CallLog("+380661234566", 15, new Date()));

        List<Message> messages = new ArrayList<>();
        messages.add(new Message("+380661234561", "Hey", new Date()));
        messages.add(new Message("+380661234561", "Hey", new Date()));
        messages.add(new Message("+380661234561", "How are you?", new Date()));
        messages.add(new Message("+380661234562", "Hello", new Date()));
        messages.add(new Message("+380661234562", "Sos", new Date()));
        messages.add(new Message("+380661234562", "Ky", new Date()));
        messages.add(new Message("+380661234563", "Good morning", new Date()));
        messages.add(new Message("+380661234563", "sup", new Date()));
        messages.add(new Message("+380661234563", "true", new Date()));
        messages.add(new Message("+380661234563", "Good day", new Date()));
        messages.add(new Message("+380661234564", "Hello", new Date()));
        messages.add(new Message("+380661234564", ":)", new Date()));
        messages.add(new Message("+380661234564", "Nice to meet you", new Date()));
        messages.add(new Message("+380661234565", "Sos", new Date()));
        messages.add(new Message("+380661234566", "Bye", new Date()));
        messages.add(new Message("+380661234566", "Good morning", new Date()));

        System.out.println("Выводим массив контактов");
        printArray(contactToArray(contacts));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим массив сообщений ");
        printArray(messageToArray(messages));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим массив звонков");
        printArray(callLogToArray(callLogs));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим коллекцию контактов соответствующую текстовому поиску");
        printContacts(findContacts(contacts, "63"));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим коллекцию сообщений соответствующую текстововму поиску");
        printMassage(findMessage(messages, "Hey"));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим коллекцию звонков соответствующую текстововму поиску");
        printCallLog(findCalls(callLogs, "65"));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим очередь контактов  с использованием FIFO методов");
        printQueueFIFO(gettingQueueFIFO(contacts));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим очередь контактов  с использованием LIFO методов");
        printQueueLIFO(gettingQueueLIFO(contacts));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим очередь сообщений   с использованием FIFO методов");
        printQueueFIFO(gettingQueueFIFO(messages));
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Выводим очередь сообщений  с использованием LIFO методов");
        printQueueLIFO(gettingQueueLIFO(messages));
    }

    // преобразуем коллекцию контактов в массив
    private static Contact[] contactToArray(Collection<Contact> contacts) {
        Contact[] arrayContacts = contacts.toArray(new Contact[0]);
        return arrayContacts;
    }

    // преобразуем коллекцию сообщений в массив
    private static Message[] messageToArray(Collection<Message> messages) {
        Message[] arrayMessage = messages.toArray(new Message[0]);
        return arrayMessage;
    }

    // преобразуем коллекцию звонков в массив
    private static CallLog[] callLogToArray(Collection<CallLog> calls) {
        CallLog[] arrayCalls = calls.toArray(new CallLog[0]);
        return arrayCalls;
    }

    // напечатаем массив
    private static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    // метод для фильтрации коллекций по предикату
    private static <E> Collection<E> filterCollection(Collection<E> collection, Predicate<E> predicate) {
        Collection<E> result = new ArrayList<>();
        for (E collection1 : collection) {
            if (predicate.test(collection1)) {
                result.add(collection1);
            }
        }
        return result;
    }

    // выполяем поиск по коллекции с контактами при помощи метода фильтрации
    private static Collection<Contact> findContacts(Collection<Contact> contacts, String text) {
        Collection<Contact> result = new ArrayList<>();
        result.addAll(filterCollection(contacts, contact -> contact.name.contains(text) || contact.phoneNumber.contains(text)));
        return result;
    }

    // выполяем поиск по коллекции со звонками при помощи метода фильтрации
    private static Collection<CallLog> findCalls(Collection<CallLog> callLogs, String text) {
        Collection<CallLog> result = new ArrayList<>();
        result.addAll(filterCollection(callLogs, callLog -> callLog.remotePhoneNumber.contains(text)));
        return result;
    }

    // выполяем поиск по коллекции с сообщениями при помощи метода фильтрации
    private static Collection<Message> findMessage(Collection<Message> messages, String text) {
        Collection<Message> result = new ArrayList<>();
        result.addAll(filterCollection(messages, message -> message.remotePhoneNumber.contains(text) || message.textMassage.contains(text)));
        return result;
    }

    // печать коллекции контактов
    private static void printContacts(Collection<Contact> contacts) {
        for (Contact contact : contacts) {
            String output = String.format(Locale.ROOT, "Name of contact %s, his number -  %s", contact.name, contact.phoneNumber);
            System.out.println(output);
        }
    }

    // печать коллекции звонков
    private static void printCallLog(Collection<CallLog> calls) {
        for (CallLog callLog : calls) {

            String output = String.format(Locale.ROOT, "Call to %s, duration -  %d, at - %s", callLog.remotePhoneNumber, callLog.duration, callLog.startDate.toString());
            System.out.println(output);
        }
    }

    // печать коллекции сообщений
    private static void printMassage(Collection<Message> messages) {
        for (Message message : messages) {
            String output = String.format(Locale.ROOT, "Massage from %s  with Text:  [ %s ] was delivered  at %s", message.remotePhoneNumber, message.textMassage, message.startDate.toString());
            System.out.println(output);
        }
    }

    // создаем очередь при помощи методов FIFO с коллекции
    private static <T> Deque<T> gettingQueueFIFO(Collection<T> collections) {
        Deque<T> result = new ArrayDeque<T>();
        for (T collection : collections) {
            result.offer(collection);
        }
        return result;
    }

    // распечатываем очередь при помощи методов FIFO
    private static <T> void printQueueFIFO(Deque<T> result) {
        while (result.peek() != null) {
            System.out.println(result.poll());
        }
    }

    // создаем очередь при помощи методов LIFO с коллекции
    private static <U> Deque<U> gettingQueueLIFO(Collection<U> collections) {
        Deque<U> result = new ArrayDeque<U>();
        for (U collection : collections) {
            result.push(collection);
        }
        return result;
    }

    // распечатываем очередь при помощи методов LIFO
    private static <U> void printQueueLIFO(Deque<U> result) {
        while (result.peek() != null) {
            System.out.println(result.pop());
        }
    }
}
