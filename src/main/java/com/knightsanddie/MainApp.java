package com.knightsanddie;

import com.knightsanddie.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX application entry point that loads a blank FXML on startup.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Initialize Hibernate (ensure DB/schema available)
        HibernateUtil.getSessionFactory();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Knights & Die");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateUtil.shutdown();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
