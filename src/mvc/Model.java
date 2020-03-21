package mvc;

import utils.Bean;

public abstract class Model extends Bean {
    private static final long serialVersionUID = 1L;

    private String fileName;
    private boolean unsavedChanges;


    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public boolean getUnsavedChanges() { return unsavedChanges; }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public void changed() {
        unsavedChanges = true;
        firePropertyChange(null, null, null);
    }

    public void copy(Model other) {
        this.fileName = other.fileName;
        this.unsavedChanges = other.unsavedChanges;
    }
}
