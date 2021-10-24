package ua.konstantynov.hw24;

import ua.konstantynov.hw24.objects.Device;
import ua.konstantynov.hw24.objects.Factory;
import ua.konstantynov.hw24.service.DeviceService;
import ua.konstantynov.hw24.service.FactoryService;

import java.util.Date;
import java.util.LinkedHashSet;

public class Main {
    private static final DeviceService deviceService = new DeviceService();
    private static final FactoryService factoryService = new FactoryService();

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.setName("name");
        factory.setCountry("country");
        factory.setDeviceSet(new LinkedHashSet<>());
        Device device = new Device();
        device.setType("type");
        device.setDeviceModel("model");
        device.setDescription("description");
        device.setCreationDate(new Date());
        device.setPrice(999.99);
        device.setPrice(999.99);
        device.setFactory(factory);

        deviceService.save(device);
        factoryService.save(factory);


    }
}