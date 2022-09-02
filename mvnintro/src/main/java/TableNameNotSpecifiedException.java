public class TableNameNotSpecifiedException extends Exception {

    public TableNameNotSpecifiedException(String className) {
        super("Table not specified for class " + className);
    }
}
