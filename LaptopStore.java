package NotebookStore;

import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 512, "Windows10", "Black", 15.6, 2.1));
        laptops.add(new Laptop("HP", 16, 256, "Ubuntu", "Silver", 14.0, 1.8));
        laptops.add(new Laptop("Lenovo", 4, 1024, "Windows11", "Gray", 13.3, 1.5));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "Space Gray", 13.3, 1.4));
        laptops.add(new Laptop("Asus", 8, 256, "Windows10", "Blue", 15.6, 2.0));
        laptops.add(new Laptop("Acer", 12, 512, "Windows10", "Black", 17.3, 2.5));
        laptops.add(new Laptop("MSI", 32, 1000, "Windows11", "Red", 15.6, 2.4));
        laptops.add(new Laptop("Samsung", 16, 512, "Windows10", "Gray", 14.0, 1.7));
        laptops.add(new Laptop("Sony", 8, 256, "Windows10", "White", 13.3, 1.6));
        laptops.add(new Laptop("Toshiba", 12, 512, "Linux", "Black", 15.6, 2.3));
        laptops.add(new Laptop("LG", 16, 1024, "Windows11", "Silver", 15.6, 2.2));
        laptops.add(new Laptop("Microsoft", 8, 256, "Windows10", "Black", 13.5, 1.3));
        laptops.add(new Laptop("Xiaomi", 16, 512, "Windows11", "Silver", 14.0, 1.8));
        laptops.add(new Laptop("Huawei", 8, 256, "Linux", "Space Gray", 13.9, 1.4));
        laptops.add(new Laptop("Google", 8, 512, "Chrome OS", "Black", 12.3, 1.1));
        laptops.add(new Laptop("Razer", 32, 1000, "Windows11", "Black", 15.6, 2.4));
        laptops.add(new Laptop("Alienware", 16, 2048, "Windows10", "Black", 17.3, 3.0));

        // Создание Map для хранения критериев фильтрации
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Запрос критериев фильтрации у пользователя
        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Размер экрана");
        System.out.println("6 - Вес");

        // Обработка выбора пользователя
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите минимальный размер ОЗУ (GB):");
                int minRam = scanner.nextInt();
                filters.put("ramSize", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД (GB):");
                int minHdd = scanner.nextInt();
                filters.put("hddSize", minHdd);
                break;
            case 3:
                System.out.println("Введите операционную систему (без пробелов):");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет на английском языке:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            case 5:
                System.out.println("Введите минимальный размер экрана (дюймы):");
                double minScreenSize = scanner.nextDouble();
                filters.put("screenSize", minScreenSize);
                break;
            case 6:
                System.out.println("Введите максимальный вес (кг):");
                double maxWeight = scanner.nextDouble();
                filters.put("weight", maxWeight);
                break;
            default:
                System.out.println("Некорректный выбор.");
                scanner.close(); // закрытие Scanner после использования
                return;
        }

        // Фильтрация ноутбуков по заданным критериям
        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);

        // Вывод результатов
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки по заданным критериям не найдены.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }

        scanner.close(); // закрытие Scanner после использования
    }

    // Метод для фильтрации ноутбуков по заданным критериям
    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean meetsCriteria = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "ramSize":
                        if (laptop.getRamSize() < (int) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "hddSize":
                        if (laptop.getHddSize() < (int) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "os":
                        // String inputOs = ((String) value).replaceAll(" ", "");
                        if (!laptop.getOs().equalsIgnoreCase((String) value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "screenSize":
                        if (laptop.getScreenSize() < (double) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "weight":
                        if (laptop.getWeight() > (double) value) {
                            meetsCriteria = false;
                        }
                        break;
                }
            }
            if (meetsCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}