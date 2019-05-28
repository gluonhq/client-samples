module hellofxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens hellofx to javafx.fxml;

    exports hellofx;
}