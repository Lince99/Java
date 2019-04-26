//https://stackoverflow.com/questions/14307676/how-to-use-a-glade-ui-glade-file-in-a-java-gnome-gtk-program
//import org.gnome.gdk.*;
import org.gnome.gtk.*;
//import java.lang.Exception;

public class Hello {
    public static void main(String[] args) {
        Gtk.init(args);
        new Label();
        Builder b = new Builder();
        try {
            b.addFromFile("Hello.glade");
        } catch(Exception fe) {
            fe.printStackTrace();
        }
        Window w = (Window) b.getObject("MainWindow");
        w.showAll();
        Gtk.main();
        //System.out.println("Hello World");
    }
}
