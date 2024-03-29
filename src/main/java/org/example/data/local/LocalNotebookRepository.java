package org.example.data.local;

import org.example.data.entities.NotebookEntity;

public class LocalNotebookRepository extends LocalRepository<NotebookEntity> {

    private LocalNotebookRepository() {}
    private static LocalNotebookRepository instance = null;
    public static LocalNotebookRepository getInstance() {
        if(instance == null) {
            instance = new LocalNotebookRepository();
        }
        return instance;
    }
}
