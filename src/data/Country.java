package data;

/**
 * Класс перечислений стран
 */
public enum Country {
    RUSSIA,
    GERMANY,
    VATICAN;

    /**
     * @return Список стран
     */
    public static String lookCountry(){
        String countryList="";
        for (Country country:values()){
            countryList +=country.name() +"\n";
        }
        System.out.println("Выберите один из предложенных вариантов");
        return countryList;
    }
}
