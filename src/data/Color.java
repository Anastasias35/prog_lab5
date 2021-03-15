package data;

/**
 * Перечисление цветов глаз и волос
 */
public enum Color {
    GREEN,
    BLUE,
    YELLOW,
    ORANGE;

    /**
     * @return список цветов
     */
    public static String lookColor(){
        String colorList="";
        for(Color color:values()){
            colorList += color.name() + "\n";
        }
        System.out.println("Выберите один из предложенных вариантов");
        return colorList;
    }
}
