//Предварительно создать базу данных
//1. Написать класс который создает две таблицы - Укстройство, Завод
//   1. Таблица устройство содержит:
//      1. Идентификатор
//      2. Тип
//      3. Название модели
//      4. Цену
//      5. Дату создания
//      6. Поле описание (текст может быть большим)
//      7. Флаг наличие на складе
//      8. Идентификатор завода
//   2. Таблица завод содержит:
//      1. Идентификатор
//      2. Название
//      3. Страну
//2. Написать класс который
//   1. генерирует 10 устройств и 4 завода. Связывает устройства с заводами и сохраняет в базу данных
//   2. достает информацию по конкретному устройству и заводу изготовителю  -
//   отображает пользователю (необходимо преобразование из ResultSet в POJO)
//   3. изменяет данные этого устройства и сохраняет в базу
//   4. удаляет конкретное устройство
//   5. Достает список всех устройств изготовленных на конкретном заводе (join)
//   6. Достает количество устройств, сумму всех устройств для каждого завода (group by)
package ua.konstantynov.hw24;

import ua.konstantynov.hw24.objects.Device;
import ua.konstantynov.hw24.service.DeviceService;
import ua.konstantynov.hw24.service.FactoryService;

public class Main {
    private static final DeviceService deviceService = new DeviceService();
    private static final FactoryService factoryService = new FactoryService();

    public static void main(String[] args) {

        Device device = deviceService.getAll().get(0);
        System.out.println(deviceService.getById(device.getId()));
        deviceService.change(device.getId(), "type", "TEST TEST TEST");
        System.out.println(deviceService.getById(device.getId()));
        System.out.println();
        System.out.println("Device count: =" + deviceService.getAll().size());
        System.out.println("Deleting Device...");
        deviceService.delete(device);
        System.out.println("Device count: =" + deviceService.getAll().size());
        System.out.println();
        System.out.println("Список устройств завода id = " + device.getFactory().getId());
        for (Device dev : deviceService.getDevicesListByFactoryId(device.getFactory().getId())) {
            System.out.println(dev);
        }
    }
}