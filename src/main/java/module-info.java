module com.example.webscraperfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.example.webscraperfx to javafx.fxml;
    exports com.example.webscraperfx;
}