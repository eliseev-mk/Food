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

    // Клиентский класс, использующий фабрику
    public static class Lunch {
        private final Soup soup;
        private final MainCourse mainCourse;

        public Lunch(MealFactory factory) {
            this.soup = factory.createSoup();
            this.mainCourse = factory.createMainCourse();
        }

        public void showMenu() {
            System.out.println("Суп: " + soup.getDescription());
            System.out.println("Главное блюдо: " + mainCourse.getDescription());
        }
    }

    public static void main(String[] args) {
        System.out.println("Мясная диета");
        MealFactory meatFactory = new MeatDietFactory();
        Lunch meatDiet = new Lunch(meatFactory);
        meatDiet.showMenu();

        System.out.println("\nВегетарианская диета");
        MealFactory veggieFactory = new VeggieDietFactory();
        Lunch veggieDiet = new Lunch(veggieFactory);
        veggieDiet.showMenu();
    }
}