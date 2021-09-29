package ua.konstantynov.hw18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class BoxService {
    static void fillFromResources(Box box, String fileName) {
        ClassLoader classLoader = BoxService.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            File file = null;
            try {
                file = new File(resource.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            if (fileName.contains(".json")) {
                fillFromJson(box, file);
            } else if (fileName.contains(".xml")) {
                fillFromXml(box, file);
            }
        }
    }

    private static void fillFromJson(Box box, File file) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null)
                list.add(str.replaceAll("[\",{}]", "").trim().split(": "));
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        box.setFrom(list.get(1)[1]);
        box.setMaterial(list.get(2)[1]);
        box.setColor(list.get(3)[1]);
        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity(list.get(5)[1], Integer.parseInt(list.get(6)[1]));
        box.setMaxLiftingCapacity(maxLiftingCapacity);
        Cargo cargo = new Cargo(list.get(9)[1], list.get(10)[1]);
        box.setCargo(cargo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            box.setDeliveryDate(simpleDateFormat.parse(list.get(12)[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void fillFromXml(Box box, File file) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null)
                list.add(str.replaceAll("[<>/\"=]", " ").trim().split(" +"));
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        box.setFrom(list.get(1)[2]);
        box.setMaterial(list.get(1)[4]);
        box.setColor(list.get(2)[1]);
        MaxLiftingCapacity maxLiftingCapacity =
                new MaxLiftingCapacity((list.get(3)[2]), Integer.parseInt(list.get(3)[3]));
        box.setMaxLiftingCapacity(maxLiftingCapacity);
        Cargo cargo = new Cargo(list.get(5)[1], list.get(6)[1]);
        box.setCargo(cargo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            box.setDeliveryDate(simpleDateFormat.parse(list.get(8)[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}