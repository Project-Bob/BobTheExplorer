module projectbob.bobtheexplorer {
    requires javafx.controls;
    requires javafx.fxml;

    opens projectbob.bobtheexplorer to javafx.fxml;
    exports projectbob.bobtheexplorer;
}
