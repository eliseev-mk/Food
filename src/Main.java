public class Main {
    // Абстрактные классы (абстрактный продукт)
    // Суп
    public static abstract class Soup {
        public abstract String getDescription();
    }

    // Главное блюдо (абстрактный продукт)
    public static abstract class MainCourse {
        public abstract String getDescription();
    }

    // Десерт
    public static abstract class Dessert {
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

    // Окрошка
    public static class Okroshka extends Soup {
        @Override
        public String getDescription() {
            return "Окрошка";
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

    // Пудинг
    public static class Pudding extends MainCourse {
        @Override
        public String getDescription() {
            return "Пудинг";
        }
    }

    // Конкретные классы десертов
    // Шоколадный торт
    public static class ChocolateCake extends Dessert {
        @Override
        public String getDescription() {
            return "Шоколадный торт";
        }
    }

    //Круассан
    public static class Croissant extends Dessert {
        @Override
        public String getDescription() {
            return "Круассан";
        }
    }

    //Йогурт
    public static class Yogurt extends Dessert {
        @Override
        public String getDescription() {
            return "Йогурт";
        }
    }

    // Абстрактная фабрика
    public interface MealFactory {
        Soup createSoup();
        MainCourse createMainCourse();
        Dessert createDessert();
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

        @Override
        public Dessert createDessert() {
            return new ChocolateCake();
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

        @Override
        public Dessert createDessert() {
            return new Croissant();
        }
    }

    // Кефирная диета
    public static class KefirDietFactory implements MealFactory {
        @Override
        public Soup createSoup() {
            return new Okroshka();
        }

        @Override
        public MainCourse createMainCourse() {
            return new Pudding();
        }

        @Override
        public Dessert createDessert() {
            return new Yogurt();
        }
    }

    // Клиентский класс, использующий фабрику
    public static class Lunch {
        private final Soup soup;
        private final MainCourse mainCourse;
        private final Dessert dessert;

        public Lunch(MealFactory factory) {
            this.soup = factory.createSoup();
            this.mainCourse = factory.createMainCourse();
            this.dessert = factory.createDessert();
        }

        public void showMenu() {
            System.out.println("Суп: " + soup.getDescription());
            System.out.println("Главное блюдо: " + mainCourse.getDescription());
            System.out.println("Десерт: " + dessert.getDescription());
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

        System.out.println("\nКефирная диета");
        MealFactory kefirFactory = new KefirDietFactory();
        Lunch kefirDiet = new Lunch(kefirFactory);
        kefirDiet.showMenu();
    }
}