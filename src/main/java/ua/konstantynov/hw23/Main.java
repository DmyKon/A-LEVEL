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
package ua.konstantynov.hw23;

import ua.konstantynov.hw23.service.CreateTable;
import ua.konstantynov.hw23.service.MyRepository;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MyRepository.dropTables();
        CreateTable.createAndFillTables(4,10); //1
        System.out.println(MyRepository.getDevice(MyRepository.getDeviceIds().get(0))); //2
        MyRepository.updateDevice(MyRepository.getDeviceIds().get(0), "type", "TEST TEST TEST"); //3
        System.out.println(MyRepository.getDevice(MyRepository.getDeviceIds().get(0)));
        MyRepository.deleteDevice(MyRepository.getDeviceIds().get(0)); //4
        System.out.println(MyRepository.getDevice(MyRepository.getDeviceIds().get(0)));
        System.out.println();
        MyRepository.getDevicesListByFactoryId(MyRepository.getFactoryIds().get(0)); //5
        System.out.println();
        MyRepository.getCountAndSumForEachFactory(); //6
        MyRepository.closeConnection();
    }
}
