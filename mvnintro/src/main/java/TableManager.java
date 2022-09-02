public class TableManager {

    protected String tableName;

    public TableManager() {
        try {
            this.readAnnotations();
        } catch (TableNameNotSpecifiedException e) {
            e.printStackTrace();
        }
    }

    protected void readAnnotations() throws TableNameNotSpecifiedException {
        Class thisClass = this.getClass();
        DatabaseTable annotation = (DatabaseTable) thisClass.getAnnotation(DatabaseTable.class);
        if (annotation != null) {
            tableName = annotation.tableName();
        } else {
            System.err.println("Cannot read DatabaseTable annotation");
            throw new TableNameNotSpecifiedException(this.getClass().getName());
        }
    }

}
