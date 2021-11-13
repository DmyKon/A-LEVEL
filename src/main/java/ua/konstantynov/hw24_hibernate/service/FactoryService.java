package ua.konstantynov.hw24_hibernate.service;

import ua.konstantynov.hw24_hibernate.dao.FactoryDao;
import ua.konstantynov.hw24_hibernate.objects.Factory;

public class FactoryService {
    private static final FactoryDao FACTORY_DAO = new FactoryDao();

    public String save(Factory factory) {
        FACTORY_DAO.save(factory);
        return factory.getId();
    }

    public Factory getById(String id) {
        return FACTORY_DAO.getById(id);
    }
}
