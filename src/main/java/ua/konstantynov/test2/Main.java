//Создать следующие классы-модели:
//* Telephone - содержит поля series, model, screen type, price
//* Television - содержит поля series, diagonal, screen type, country, price
//* Customer - содержит поля id, email, age
//* Invoice - содержит список товаров (Telephone/Television), Customer, type
//   * Если общая сумма привышает заданный лимит (лимит устнавливается при запуске приложения) то type - wholesale,
//   если не привышает - retail
//
//Создать csv файл в директории ресурсов, сследующего типа
//type,series,model,diagonal,screen type,country,price
//Telephone,S-10,Samsung,none,QLED,none,200
//Television,RTI-14,none,25,LED,China,1500
//….
//Придумать по 10 позиций на каждый тип товара.
//Добавить в файл одну “сломанную” строку (например пропустить значение и узказать LED,,1500).
//
//Создать свое исключение:
//* Создать исключение которое будет говорить о прочтении некорректной строки
//
//Создать классы-сервисы:
//* PersonService - генерирует случайного покупателя
//* ShopService:
//   * считывает данные из ранее созданного csv файла и случайным образом формирует заказ состоящий из 1-5 позиций.
//      * Если считывается некоректная строка нужно выбросить и правильно обработать исключение
//   * Сформированный заказ логирует в отдельный файл в формате
//      * [time] [user-data] [invoice-data]
//   * Так же сформированные заказы сохраняються в хранилище (подходящяя колекция)
//
//После эмуляции покупки 15 заказов вывести в консоль следующие аналитические данные:
//* Количество проданных товаров по категориям (Telephone/Television)
//* Сумму самого маленького чека и информацию о покупателе
//* Сумму всех покупок
//* Количество чеков с категорией retail
//* Чеки которые содержат только один тип товара
//* Первые три чека сделанные покупателями
//* Информацию по чекам купленных пользователем младше 18 лет, при этом изменить тип чека на low_age
//* Написать метод который сортирует (любым известным способом) все заказы в следующем порядке:
//   * Сначала по возрасту покупателя от большего к меньшему
//   * Далее по количеству купленных предметов
//   * Далее по общей сумме купленных предметов
//
//Критерии оценивания:
//* Работоспособность кода
//* Чистота и читаемость кода
//* Разделение на классы/пакеты
//* Использование Stream API
package ua.konstantynov.test2;

import ua.konstantynov.test2.objects.Product;
import ua.konstantynov.test2.service.ShopService;
import ua.konstantynov.test2.service.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> list = ShopService.readCsvFile("goods.csv");
        System.out.println("Введите лимит общей суммы...");
        int totalAmountLimit = new Scanner(System.in).nextInt();
        for (int i = 0; i < 15; i++) {
            ShopService.setRandomInvoice(list, totalAmountLimit);
        }
        System.out.println("Количество проданных товаров: Telephone = "
                + Util.countOfProductSoldByCategory("Telephone") +
                ", Television = " + Util.countOfProductSoldByCategory("Television"));
        System.out.println("Сумма самого маленького чека = " + Util.minimumCheckAmountAndCustomer().keySet() +
                ", Клиент = " + Util.minimumCheckAmountAndCustomer().values());
        System.out.println("Сумма всех покупок = " + Util.totalAmountSold());
        System.out.println("Количество чеков с категорией retail = " + Util.retailCheckCount());
        System.out.println("Чеки, которые содержат только один тип товара: " + Util.onlyOneCategoryChecks());
        System.out.println("Первые три чека сделанные покупателями: " +
                ShopService.getInvoices().stream()
                        .sorted(Comparator.comparing(invoice -> invoice.getDateTime().getTime()))
                        .limit(3).collect(Collectors.toList()));
        System.out.println("Чеки купленные пользователями младше 18 лет " + Util.lowAgeCheckInfo());
        System.out.println("Сортировка: " + Util.sorting());
    }
}