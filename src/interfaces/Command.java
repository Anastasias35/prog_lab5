package interfaces;

/**
 * Интерфейс для всех команд
 */
public interface Command {
    String getName();
    String getDescription();
    boolean execute(String argument);
}