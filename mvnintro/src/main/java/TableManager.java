public class TableManager {

    protected String tableName;
    protected String tableColumn;

//    public TableManager() {
//        System.out.println("===== Creating task manager");
//        try {
//            this.readAnnotations();
//        } catch (TableNameNotSpecifiedException e) {
//            e.printStackTrace();
//        }
//    }

    protected void readAnnotations() throws TableNameNotSpecifiedException {
        System.out.println("===== Reading annotations");
        Class thisClass = this.getClass();
        DatabaseTable annotation = (DatabaseTable) thisClass.getAnnotation(DatabaseTable.class);
        if (annotation != null) {
            tableName = annotation.tableName();
            System.out.println("Table name: " + tableName);
            tableColumn = annotation.tableColumn();
            System.out.println("Column name: " + tableColumn);
        } else {
            System.err.println("Cannot read DatabaseTable annotation");
            throw new TableNameNotSpecifiedException(this.getClass().getName());
        }
    }

}
