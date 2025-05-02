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

    // Конкретные классы вторых блюд
    //Жареная картошка
    public static class FriedPotatoes extends MainCourse {
        @Override
        public String getDescription() {
            return "Жареная картошка";
        }
    }

    // Котлета
    public static class Cutlet extends MainCourse {
        @Override
        public String getDescription() {
            return "Котлета";
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
            return new Borscht();
        }

        @Override
        public MainCourse createMainCourse() {
            return new Cutlet();
        }
    }

    // Вегетарианская диета
    public static class VeggieDietFactory implements MealFactory {
        @Override
        public Soup createSoup() {
            return new PumpkinSoup();
        }

        @Override
        public MainCourse createMainCourse() {
            return new FriedPotatoes();
        }
    }

    public static void main(String[] args) {
        System.out.println("Мясная диета");
        System.out.println("\nВегетарианская диета");
    }
}