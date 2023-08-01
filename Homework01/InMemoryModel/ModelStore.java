package Homework01.InMemoryModel;

import Homework01.ModelElements.Camera;
import Homework01.ModelElements.Flash;
import Homework01.ModelElements.PoligonalModel;
import Homework01.ModelElements.Scene;

public abstract class ModelStore implements IModelChanger, IModelChangedObserver {
    public PoligonalModel Models;
    public Scene Scenes;
    public Flash Flashes;
    public Camera Cameras;
    private IModelChangedObserver changedObservers;

    // сделаем геттер, чтобы у 'changedObservers' не было варнинга
    public IModelChangedObserver getChangedObservers() {
        return changedObservers;
    }

    public Scene getScena(int id) {
        // чтобы меньше ругался редактор - объявим и инициализируем 'temp'
        Scene temp = null;
        return temp;
    }

    @Override
    public void NotifyChange(IModelChanger sender) {
        // 
    }
    
}
