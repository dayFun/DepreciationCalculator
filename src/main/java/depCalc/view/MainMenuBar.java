package depCalc.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenuBar extends JMenuBar {

    private static final long serialVersionUID = -5633050139810521696L;
    private JMenuItem exitMenuItem;

    public MainMenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        exitMenuItem = new JMenuItem("Exit");

        fileMenu.add(exitMenuItem);

        add(fileMenu);
        add(helpMenu);
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

}
