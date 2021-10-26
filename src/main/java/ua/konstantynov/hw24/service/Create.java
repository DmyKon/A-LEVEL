package ua.konstantynov.hw24.service;

import ua.konstantynov.hw24.objects.Device;
import ua.konstantynov.hw24.objects.Factory;

import java.util.Date;

public class Create {
    private static final DeviceService deviceService = new DeviceService();
    private static final FactoryService factoryService = new FactoryService();

    public static void fillTables() {
        String factory1_id = factoryService.save(new Factory("name_1", "country_1"));
        String factory2_id = factoryService.save(new Factory("name_2", "country_2"));
        String factory3_id = factoryService.save(new Factory("name_3", "country_3"));
        String factory4_id = factoryService.save(new Factory("name_4", "country_4"));
        deviceService.save(new Device("type_1", "deviceModel_1", 100d, new Date(),
                "description_1", true, factoryService.getById(factory1_id)));
        deviceService.save(new Device("type_2", "deviceModel_2", 200d, new Date(),
                "description_2", true, factoryService.getById(factory2_id)));
        deviceService.save(new Device("type_3", "deviceModel_3", 300d, new Date(),
                "description_3", true, factoryService.getById(factory3_id)));
        deviceService.save(new Device("type_4", "deviceModel_4", 400d, new Date(),
                "description_4", true, factoryService.getById(factory4_id)));
        deviceService.save(new Device("type_5", "deviceModel_5", 500d, new Date(),
                "description_5", true, factoryService.getById(factory1_id)));
        deviceService.save(new Device("type_6", "deviceModel_6", 600d, new Date(),
                "description_6", true, factoryService.getById(factory2_id)));
        deviceService.save(new Device("type_7", "deviceModel_7", 700d, new Date(),
                "description_7", true, factoryService.getById(factory3_id)));
        deviceService.save(new Device("type_8", "deviceModel_8", 800d, new Date(),
                "description_8", true, factoryService.getById(factory4_id)));
        deviceService.save(new Device("type_9", "deviceModel_9", 900d, new Date(),
                "description_9", true, factoryService.getById(factory1_id)));
        deviceService.save(new Device("type_10", "deviceModel_10", 1000d, new Date(),
                "description_10", true, factoryService.getById(factory2_id)));
    }
}
