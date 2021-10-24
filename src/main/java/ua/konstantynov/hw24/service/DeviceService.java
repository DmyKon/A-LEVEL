package ua.konstantynov.hw24.service;

import ua.konstantynov.hw24.dao.DeviceDao;
import ua.konstantynov.hw24.objects.Device;

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

    public List<Device> getAll() {
        return DEVICE_DAO.getAll();
    }

    public void delete(Device device) {
        DEVICE_DAO.deleteById(device.getId());
    }
}
