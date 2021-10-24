package ua.konstantynov.hw24.service;

import ua.konstantynov.hw24.dao.FactoryDao;
import ua.konstantynov.hw24.objects.Factory;

public class FactoryService {
    private static final FactoryDao FACTORY_DAO = new FactoryDao();

    public String save(Factory factory) {
        FACTORY_DAO.save(factory);
        return factory.getId();
    }

}
