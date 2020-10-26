package event;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;;

public class MyItem implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Changed");
	}
}
