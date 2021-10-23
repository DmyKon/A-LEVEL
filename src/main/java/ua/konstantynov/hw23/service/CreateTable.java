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
            String sql = "CREATE TABLE `a_level`.`factory` (\n" +
                    "  `factory_id` VARCHAR(36) NOT NULL,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `country` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`factory_id`),\n" +
                    "  UNIQUE INDEX `factory_id_UNIQUE` (`factory_id` ASC) VISIBLE);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDeviceTable() {
        try {
            String sql = "CREATE TABLE `device` (\n" +
                    "  `device_id` varchar(36) NOT NULL,\n" +
                    "  `type` varchar(45) DEFAULT NULL,\n" +
                    "  `model` varchar(45) DEFAULT NULL,\n" +
                    "  `price` decimal(8,2) DEFAULT NULL,\n" +
                    "  `date` date DEFAULT NULL,\n" +
                    "  `description` text,\n" +
                    "  `in_stock` bit(1) DEFAULT NULL,\n" +
                    "  `factory_identifier` varchar(36) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`device_id`),\n" +
                    "  UNIQUE KEY `device_id_UNIQUE` (`device_id`),\n" +
                    "  KEY `factory_identifier factory_idx` (`factory_identifier`),\n" +
                    "  CONSTRAINT `factory_identifier` FOREIGN KEY (`factory_identifier`)" +
                    "  REFERENCES `factory` (`factory_id`)\n" +
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
            String sql = "SELECT factory_id FROM `a_level`.`factory`;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                factoryIds.add(resultSet.getString("factory_id"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillDeviceIdList() {
        try {
            String sql = "SELECT device_id FROM `a_level`.`device`;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                deviceIds.add(resultSet.getString("device_id"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}