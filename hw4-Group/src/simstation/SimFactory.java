package simstation;

/*
 * Edit history:
 *   Quang-Duy, 04/12: created SimFactory class
*/

import mvc.*;

public interface SimFactory extends AppFactory {
	public View getView(Model model);
}
