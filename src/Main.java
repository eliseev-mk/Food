public class Main {
    // Абстрактные классы (абстрактный продукт)
    public static abstract class Soup {
        public abstract String getDescription();
    }

    // Главное блюдо (абстрактный продукт)
    public static abstract class MainCourse {
        public abstract String getDescription();
    }

    // Конкретные классы супов
    // Борщ
    public static class Borscht extends Soup {
        @Override
        public String getDescription() {
            return "Борщ";
        }
    }

    // Тыквенный суп
    public static class PumpkinSoup extends Soup {
        @Override
        public String getDescription() {
            return "Тыквенный суп";
        }
    }

    // Абстрактная фабрика
    public interface MealFactory {
        Soup createSoup();
        MainCourse createMainCourse();
    }

    // Конкретные фабрики
    // Мясная диета
    public static class MeatDietFactory implements MealFactory {
        @Override
        public Soup createSoup() {
            return null;
        }

        @Override
        public MainCourse createMainCourse() {
            return null;
        }
    }

    // Вегетерианская диета
    public static class VeggieDietFactory implements MealFactory {
        @Override
        public Soup createSoup() {
            return null;
        }

        @Override
        public MainCourse createMainCourse() {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Мясная диета");
        System.out.println("\nВегетерианская диета");
    }
}