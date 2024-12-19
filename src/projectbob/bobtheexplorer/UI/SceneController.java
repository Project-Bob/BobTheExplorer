package projectbob.bobtheexplorer.UI;

import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Stack;

public class SceneController {
    private static Stage primaryStage; // Store the primary stage
    private static Stack<Scene> sceneStack = new Stack<>(); // Stack to keep scene history

    // Initialize the stage
    public static void init(Stage stage) {
        primaryStage = stage;
    }

    // Set the current scene and show it
    public static void setScene(Scene scene) {
        if (primaryStage.getScene() != null) {
            sceneStack.push(primaryStage.getScene()); // Push the current scene onto the stack
        }
        primaryStage.setScene(scene); // Set the new scene
        primaryStage.show(); // Show the new scene
    }

    // Go back to the previous scene
    public static void goBack() {
        if (!sceneStack.isEmpty()) {
            Scene previousScene = sceneStack.pop(); // Pop the previous scene
            primaryStage.setScene(previousScene); // Set the previous scene
            primaryStage.show(); // Show the previous scene
        }
    }

    // Get the current scene
    public static Scene getCurrentScene() {
        return primaryStage.getScene(); // Return the current scene
    }
}