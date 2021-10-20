package ua.konstantynov.hw23.service;

import ua.konstantynov.hw23.objects.Device;
import ua.konstantynov.hw23.objects.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class MyRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/a_level";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    private static final List<String> factoryIds = new ArrayList<>();
    private static final List<String> deviceIds = new ArrayList<>();

    public static List<String> getDeviceIds() {
        return deviceIds;
    }

    public static List<String> getFactoryIds() {
        return factoryIds;
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createAndFillTables(int factoryCount, int deviceCount) {
        MyRepository.createFactoryTable();
        MyRepository.createDeviceTable();
        MyRepository.fillFactoryTable(factoryCount);
        MyRepository.fillFactoryIdList();
        MyRepository.fillDeviceTable(deviceCount);
        MyRepository.fillDeviceIdList();
        closeConnection();
    }

    private static void createFactoryTable() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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

    private static void createDeviceTable() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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

    private static void fillFactoryTable(int count) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String[] factoryName = {"BRGr", "Pzza", "SLO", "DG"};
            String[] factoryCountry = {"USA", "Korea", "Ukraine", "Italy"};
            PreparedStatement preparedStatement = null;
            for (int i = 0; i < count; i++) {
                String sql = "INSERT INTO a_level.завод (завод_id, Название, Страна) VALUES (?, ?, ?);";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2,
                        factoryName[ThreadLocalRandom.current().nextInt(factoryName.length)]);
                preparedStatement.setString(3,
                        factoryCountry[ThreadLocalRandom.current().nextInt(factoryCountry.length)]);
                preparedStatement.executeUpdate();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillDeviceTable(int count) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String[] deviceType = {"TV", "Phone", "Fridge", "Watch"};
            String[] deviceModelName = {"A-53453", "B-43543", "C-63463", "D-63443", "F-5435", "G-8654", "H-87126"};
            String[] deviceCreationDate = {"2000-12-30", "2021-03-03", "2009-08-14", "2005-11-21", "1980-05-23"};
            String[] deviceDescription = {"No in he real went find mr. Wandered or strictly raillery stanhill as. " +
                    "Jennings appetite disposed me an at subjects an. To no indulgence diminution so discovered mr " +
                    "apartments. Are off under folly death wrote cause her way spite. Plan upon yet way get cold spot " +
                    "its week. Almost do am or limits hearts. Resolve parties but why she shewing. She sang know now " +
                    "how nay cold real case.", "Started several mistake joy say painful removed reached end. " +
                    "State burst think end are its. Arrived off she elderly beloved him affixed noisier yet." +
                    " An course regard to up he hardly. View four has said does men saw find dear shy. Talent " +
                    "men wicket add garden.", "Is post each that just leaf no. He connection interested so we an " +
                    "sympathize advantages. To said is it shed want do. Occasional middletons everything so to. " +
                    "Have spot part for his quit may. Enable it is square my an regard. Often merit stuff first oh" +
                    " up hills as he. Servants contempt as although addition dashwood is procured. Interest in " +
                    "yourself an do of numerous feelings cheerful confined.", "You disposal strongly quitting his " +
                    "endeavor two settling him. Manners ham him hearted hundred expense. Get open game him what " +
                    "hour more part. Adapted as smiling of females oh me journey exposed concern. Met come add cold " +
                    "calm rose mile what. Tiled manor court at built by place fanny. Discretion at be an so " +
                    "decisively especially. Exeter itself object matter if on mr in."};
            PreparedStatement preparedStatement = null;
            for (int i = 0; i < count; i++) {
                String sql = "INSERT INTO `a_level`.`устройство` (`устройство_id`, `Тип`, " +
                        "`Название_модели`, `Цена`, `Дата_создания`, `Описание`, `Наличие_на_складе`, " +
                        "`Идентификатор_завода`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2,
                        deviceType[ThreadLocalRandom.current().nextInt(deviceType.length)]);
                preparedStatement.setString(3,
                        deviceModelName[ThreadLocalRandom.current().nextInt(deviceModelName.length)]);
                preparedStatement.setDouble(4,
                        ThreadLocalRandom.current().nextDouble(1000, 10000));
                preparedStatement.setString(5,
                        deviceCreationDate[ThreadLocalRandom.current().nextInt(deviceCreationDate.length)]);
                preparedStatement.setString(6,
                        deviceDescription[ThreadLocalRandom.current().nextInt(deviceDescription.length)]);
                preparedStatement.setInt(7,
                        ThreadLocalRandom.current().nextInt(2));
                preparedStatement.setString(8,
                        factoryIds.get(ThreadLocalRandom.current().nextInt(factoryIds.size())));
                preparedStatement.executeUpdate();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillFactoryIdList() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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

    public static void dropTables() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "DROP TABLE `a_level`.`устройство`;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DROP TABLE `a_level`.`завод`;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Factory getFactory(String id) {
        Factory factory = new Factory();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM `a_level`.`завод` WHERE завод_id = '" + id + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                factory.setId(resultSet.getString("завод_id"));
                factory.setName(resultSet.getString("Название"));
                factory.setCountry(resultSet.getString("Страна"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return factory;
    }


    public static Device getDevice(String id) {
        Device device = new Device();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM `a_level`.`устройство` WHERE устройство_id = '" + id + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                device.setId(resultSet.getString("устройство_id"));
                device.setType(resultSet.getString("Тип"));
                device.setDeviceModel(resultSet.getString("Название_модели"));
                device.setPrice(resultSet.getDouble("Цена"));
                device.setCreationDate(resultSet.getDate("Дата_создания"));
                device.setDescription(resultSet.getString("Описание"));
                device.setIsInStock(resultSet.getBoolean("Наличие_на_складе"));
                device.setFactory(getFactory(resultSet.getString("Идентификатор_завода")));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return device;
    }

    public static void updateDevice(String id, String column, String value) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "UPDATE `a_level`.`устройство` SET `" + column + "` = '" + value + "' " +
                    "WHERE (`устройство_id` = '" + id + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDevice(String id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "DELETE FROM `a_level`.`устройство` " +
                    "WHERE (`устройство_id` = '" + id + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            deviceIds.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDevicesListByFactoryId(String id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM `a_level`.`устройство` WHERE Идентификатор_завода = '" + id + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Список устройств завода id = " + id);
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getCountAndSumForEachFactory() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT Идентификатор_завода, SUM(Цена) AS Сумма, COUNT(Идентификатор_завода) AS Количество " +
                    "FROM a_level.устройство " +
                    "GROUP BY Идентификатор_завода;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        "Идентификатор_завода = " + resultSet.getString("Идентификатор_завода") +
                                " Сумма = " + resultSet.getString("Сумма") +
                                " Количество = " + resultSet.getString("Количество"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
