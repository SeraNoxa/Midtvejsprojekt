module Midtvejsprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;

    opens presentation;
    opens data to javafx.base;
}