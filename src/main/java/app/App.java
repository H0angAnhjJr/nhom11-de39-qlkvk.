package app;

import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Views.changeFrame("login");
        });
    }
}
