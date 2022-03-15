package notepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class noteBase extends BorderPane {

    String currentPath = null;
    String currentText = null;
    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem new1;
    protected final MenuItem open;
    protected final MenuItem save1;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem exit1;
    protected final Menu menu0;
    protected final MenuItem undo1;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem cut1;
    protected final MenuItem copy1;
    protected final MenuItem paste1;
    protected final MenuItem delete1;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem selectall;
    protected final Menu menu1;
    protected final MenuItem menuItem;
    protected final TextArea textArea;
    protected final MenuItem about;

    public noteBase(Stage stage) {

        menuBar = new MenuBar();
        menu = new Menu();
        new1 = new MenuItem();
        open = new MenuItem();
        save1 = new MenuItem();
        separatorMenuItem = new SeparatorMenuItem();
        exit1 = new MenuItem();
        menu0 = new Menu();
        undo1 = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        cut1 = new MenuItem();
        copy1 = new MenuItem();
        paste1 = new MenuItem();
        delete1 = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        selectall = new MenuItem();
        menu1 = new Menu();
        menuItem = new MenuItem();
        textArea = new TextArea();
        about = new MenuItem();

        textArea.setText("");
        //new action
        //  new1.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        new1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                textArea.clear();
            }
        });

        //open Action
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fC = new FileChooser();
                File selectedFile = fC.showOpenDialog(stage);

                if (selectedFile != null) {
                    String path = selectedFile.getPath();
                    try {
                        FileInputStream fInputStream = new FileInputStream(path);
                        byte[] text = new byte[fInputStream.available()];
                        fInputStream.read(text);
                        textArea.setText(new String(text));
                        currentText = textArea.getText();
                        fInputStream.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(noteBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(noteBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        //save action
        save1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (currentPath == null) {
                    FileChooser fC = new FileChooser();
                    fC.getExtensionFilters().add(
                            new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt")
                    );
                    fC.setTitle("Save File");
                    File selectedFile = fC.showSaveDialog(stage);
                    if (selectedFile != null) {
                        String path = selectedFile.getPath();
                        currentPath = path;
                    }
                }
                if (currentPath != null) {
                    try {
                        try (FileOutputStream fOutputStream = new FileOutputStream(currentPath)) {
                            byte[] text = textArea.getText().getBytes();
                            fOutputStream.write(text);
                            textArea.setText(new String(text));
                            currentText = textArea.getText();
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(noteBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(noteBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //exit action
        exit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Platform.exit();
            }
        });
        //undo action
        undo1.setOnAction(e -> {
            textArea.undo();
        });
        //cut action
        cut1.setOnAction(e -> {
            textArea.getSelection();
            textArea.cut();
        });
        //COPY ACTION
        copy1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //textArea.getSelectedText().copy();
                textArea.getSelection();
                textArea.copy();
            }
        });
        //PASTE ACTION
        paste1.setOnAction(e -> {
            textArea.paste();
        });
        //delete action
        delete1.setOnAction(e -> {
          textArea.deleteText(textArea.getSelection());
            
        });
        //selectAll action
        selectall.setOnAction(e -> {
            textArea.selectAll();
        });
        //about notepad action
        about.setOnAction((ActionEvent e) -> {
            Alert alert = new Alert(AlertType.INFORMATION, "You pressed About Item in Help Menu");
            alert.show();
        });
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        new1.setMnemonicParsing(false);
        new1.setText("New");

        open.setMnemonicParsing(false);
        open.setText("Open");

        save1.setMnemonicParsing(false);
        save1.setText("Save");

        separatorMenuItem.setMnemonicParsing(false);

        exit1.setMnemonicParsing(false);
        exit1.setText("Exit");

        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        undo1.setMnemonicParsing(false);
        undo1.setText("Undo");

        separatorMenuItem0.setMnemonicParsing(false);

        cut1.setMnemonicParsing(false);
        cut1.setText("Cut");

        copy1.setMnemonicParsing(false);
        copy1.setText("Copy");

        paste1.setMnemonicParsing(false);
        paste1.setText("Paste");

        delete1.setMnemonicParsing(false);
        delete1.setText("Delete");

        separatorMenuItem1.setMnemonicParsing(false);

        selectall.setMnemonicParsing(false);
        selectall.setText("Select All");

        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        about.setMnemonicParsing(false);
        about.setText("About Notepad");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setId("textarea");
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(new1);
        menu.getItems().add(open);
        menu.getItems().add(save1);
        menu.getItems().add(separatorMenuItem);
        menu.getItems().add(exit1);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(undo1);
        menu0.getItems().add(separatorMenuItem0);
        menu0.getItems().add(cut1);
        menu0.getItems().add(copy1);
        menu0.getItems().add(paste1);
        menu0.getItems().add(delete1);
        menu0.getItems().add(separatorMenuItem1);
        menu0.getItems().add(selectall);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(about);
        menuBar.getMenus().add(menu1);

    }
}
