package data;

/**
 * Класс перечислений профессий
 */
public enum Position {
    DIRECTOR,
    ENGINEER,
    LEAD_DEVELOPER,
    CLEANER;

    /**
     * @return Список профессий
     */
    public static String lookPosition(){
        String positionList="";
        for(Position position:values()){
            positionList +=position.name() + "\n";
        }
        System.out.println("Выберите один из предложенных вариантов" );
        return positionList;
    }
}

