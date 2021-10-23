package ua.konstantynov.hw23.service;

import ua.konstantynov.hw23.objects.Device;
import ua.konstantynov.hw23.objects.Factory;

import java.sql.*;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class MyRepository extends AbstractRepository {
    public static void fillFactoryTable(int count) {
        try {
            String[] factoryName = {"BRGr", "Pzza", "SLO", "DG"};
            String[] factoryCountry = {"USA", "Korea", "Ukraine", "Italy"};
            PreparedStatement preparedStatement = null;
            for (int i = 0; i < count; i++) {
                String sql = "INSERT INTO a_level.factory (factory_id, name, country) VALUES (?, ?, ?);";
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

    public static void fillDeviceTable(int count) {
        try {
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
                String sql = "INSERT INTO `a_level`.`device` (`device_id`, `type`, " +
                        "`model`, `price`, `date`, `description`, `in_stock`, " +
                        "`factory_identifier`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
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

    public static void dropTables() {
        try {
            String sql = "DROP TABLE `a_level`.`device`;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql = "DROP TABLE `a_level`.`factory`;";
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
            String sql = "SELECT * FROM `a_level`.`factory` WHERE factory_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                factory.setId(resultSet.getString("factory_id"));
                factory.setName(resultSet.getString("name"));
                factory.setCountry(resultSet.getString("country"));
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
            String sql = "SELECT * FROM `a_level`.`device` WHERE device_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                device.setId(resultSet.getString("device_id"));
                device.setType(resultSet.getString("type"));
                device.setDeviceModel(resultSet.getString("model"));
                device.setPrice(resultSet.getDouble("price"));
                device.setCreationDate(resultSet.getDate("date"));
                device.setDescription(resultSet.getString("description"));
                device.setIsInStock(resultSet.getBoolean("in_stock"));
                device.setFactory(getFactory(resultSet.getString("factory_identifier")));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return device;
    }

    public static void updateDevice(String id, String column, String value) {
        try {
            String sql = String.format("UPDATE `a_level`.`device` SET %s = ? " +
                    "WHERE (`device_id` = ?);", column);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDevice(String id) {
        try {
            String sql = "DELETE FROM `a_level`.`device` " +
                    "WHERE (`device_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            deviceIds.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDevicesListByFactoryId(String id) {
        try {
            String sql = "SELECT * FROM device\n" +
                    "INNER JOIN factory \n" +
                    "ON factory_identifier = factory_id AND factory_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
            String sql = "SELECT factory_identifier, SUM(price) AS total, COUNT(factory_identifier) AS count " +
                    "FROM a_level.device " +
                    "GROUP BY factory_identifier;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        "Идентификатор завода = " + resultSet.getString("factory_identifier") +
                                " Сумма = " + resultSet.getString("total") +
                                " Количество = " + resultSet.getString("count"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
