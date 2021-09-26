package ua.konstantynov.hw17.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BoxService {
    static boolean boxesSizeLimitFilter(int size) {
        int min = ThreadLocalRandom.current().nextInt(1, 500);
        int max = min + ThreadLocalRandom.current().nextInt(500);
        return size >= min && size <= max;
    }

    static void fillRandomBoxes(List<Box> boxList, int count) {
        String itemNames = "шуба наушник парус аврора авиашкола гепард инвентарь манекен кулек " +
                "родинка лента пудинг дамба вешалка карета сиденье одеяло медпункт кислота " +
                "муравей атлетика загар софа страница грузовик сорока бадья обшивка ворс";
        String[] itemNamesArr = itemNames.split(" ");
        for (int i = 0; i < count; i++) {
            List<Item> itemList = new ArrayList<>();
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(itemNames.length()) / 5; j++) {
                itemList.add(new Item(itemNamesArr[ThreadLocalRandom.current().nextInt(itemNamesArr.length)],
                        ThreadLocalRandom.current().nextInt(10000)));
            }
            boxList.add(new Box(itemList, ThreadLocalRandom.current().nextInt(1, 1000)));
        }
    }
}