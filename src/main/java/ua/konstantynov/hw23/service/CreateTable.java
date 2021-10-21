package ua.konstantynov.hw23.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable extends AbstractRepository {
    public static void createAndFillTables(int factoryCount, int deviceCount) {
        createFactoryTable();
        createDeviceTable();
        MyRepository.fillFactoryTable(factoryCount);
        fillFactoryIdList();
        MyRepository.fillDeviceTable(deviceCount);
        fillDeviceIdList();
    }

    public static void createFactoryTable() {
        try {
            String sql = "CREATE TABLE `a_level`.`завод` (\n" +
                    "  `завод_id` VARCHAR(36) NOT NULL,\n" +
                    "  `Название` VARCHAR(45) NULL,\n" +
                    "  `Страна` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`завод_id`),\n" +
                    "  UNIQUE INDEX `завод_id_UNIQUE` (`завод_id` ASC) VISIBLE);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDeviceTable() {
        try {
            String sql = "CREATE TABLE `устройство` (\n" +
                    "  `устройство_id` varchar(36) NOT NULL,\n" +
                    "  `Тип` varchar(45) DEFAULT NULL,\n" +
                    "  `Название_модели` varchar(45) DEFAULT NULL,\n" +
                    "  `Цена` decimal(8,2) DEFAULT NULL,\n" +
                    "  `Дата_создания` date DEFAULT NULL,\n" +
                    "  `Описание` text,\n" +
                    "  `Наличие_на_складе` bit(1) DEFAULT NULL,\n" +
                    "  `Идентификатор_завода` varchar(36) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`устройство_id`),\n" +
                    "  UNIQUE KEY `устройство_id_UNIQUE` (`устройство_id`),\n" +
                    "  KEY `Идентификатор завода_idx` (`Идентификатор_завода`),\n" +
                    "  CONSTRAINT `Идентификатор_завода` FOREIGN KEY (`Идентификатор_завода`)" +
                    "  REFERENCES `завод` (`завод_id`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillFactoryIdList() {
        try {
            String sql = "SELECT завод_id FROM `a_level`.`завод`;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                factoryIds.add(resultSet.getString("завод_id"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillDeviceIdList() {
        try {
            String sql = "SELECT устройство_id FROM `a_level`.`устройство`;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                deviceIds.add(resultSet.getString("устройство_id"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}