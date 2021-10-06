package ua.konstantynov.test2.service;

import ua.konstantynov.test2.objects.Customer;

import java.util.concurrent.ThreadLocalRandom;

public class PersonService {
    public static Customer setRandom() {
        String[] email = ("tymokomor thosiitit eeforkokos tythoforfor kossithotho mormorforee ititkoty formortykos " +
                "simokoi kokuiit forsieezo kukumorko zomokofor komorzozo morsiiit forsikosmo sikueesi itzoitee " +
                "iforthoty mormosimo eemoritmor kosmoeeku itzotymor itmormorit kuthoeeko kukoeekos ").split(" ");
        return new Customer(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE),
                email[ThreadLocalRandom.current().nextInt(email.length)] + "@mail.com",
                ThreadLocalRandom.current().nextInt(10, 70));
    }
}