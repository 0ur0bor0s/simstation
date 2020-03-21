package mvc;

import turtle.Turtle;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JComponent implements PropertyChangeListener {
    protected Model model;

    public View(Model model) {
        super();
        this.model = model;
        model.addPropertyChangeListener(this);

        //optional border around the view component
        setBorder(LineBorder.createBlackLineBorder());
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model newModel) {
        if (this.model != null) this.model.removePropertyChangeListener(this);
        this.model = newModel;
        if (newModel != null) {
            this.model.addPropertyChangeListener(this);
            repaint();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        repaint();
    }
}
