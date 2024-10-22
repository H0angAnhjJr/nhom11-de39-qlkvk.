package app;

import java.util.Map;

import utilities.views.TabFrame;

import views.*;
import views.Panels.*;

public class Views {
    public static LoginView loginView = new LoginView();
    public static TabFrame menuView = new TabFrame(Map.ofEntries(
            Map.entry("Quân Trang", new QuanTrangView()))
    );

    public static void changeFrame(String frame) {
        loginView.setVisible(false);
        menuView.setVisible(false);

        switch (frame) {
            case "login":
                loginView.setVisible(true);
                break;
            case "menu":
                menuView.setVisible(true);
                break;
        }
    }
}
