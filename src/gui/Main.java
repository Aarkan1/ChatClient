package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import network.ChatClient;

public class Main extends Application {
    public static Stage stage;
    private Parent root;

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("chatUI.fxml"));
        Main.stage = stage;
        stage.setTitle("ChatApp");

//        initialize server connection by calling singleton
        ChatClient.get();

        stage.setScene(new Scene(root, 400, 600));

        stage.setOnCloseRequest(e -> ChatClient.get().closeThreads());
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}
