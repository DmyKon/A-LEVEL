package ua.konstantynov.hw24_hibernate.service;

import ua.konstantynov.hw24_hibernate.dao.DeviceDao;
import ua.konstantynov.hw24_hibernate.objects.Device;
import ua.konstantynov.hw24_hibernate.objects.DeviceDto;

import java.util.List;

public class DeviceService {
    private static final DeviceDao DEVICE_DAO = new DeviceDao();

    public String save(Device device) {
        DEVICE_DAO.save(device);
        return device.getId();
    }

    public Device getById(String id) {
        return DEVICE_DAO.getById(id);
    }

    public void change(String id, String column, String value) {
        DEVICE_DAO.change(id, column, value);
    }

    public List<Device> getDevicesListByFactoryId(String id) {
        return DEVICE_DAO.getDevicesListByFactoryId(id);
    }

    public List<DeviceDto> getCountAndSumForEachFactory() {
        return DEVICE_DAO.getCountAndSumForEachFactory();
    }

    public List<Device> getAll() {
        return DEVICE_DAO.getAll();
    }

    public void delete(Device device) {
        DEVICE_DAO.delete(device.getId());
    }
}
