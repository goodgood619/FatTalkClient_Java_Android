package ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;

public abstract class BaseViewModel extends AndroidViewModel implements LifecycleObserver, Observable {
    private PropertyChangeRegistry callbacks;
    public BaseViewModel(@NonNull Application application){
        super(application);
    }

    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback){
        if(callbacks == null){
            callbacks = new PropertyChangeRegistry();
        }
        callbacks.add(onPropertyChangedCallback);
    }

    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback){
        if(callbacks == null){
            callbacks = new PropertyChangeRegistry();
        }
        callbacks.remove(onPropertyChangedCallback);
    }

    public void notifyChange(){
        synchronized (this){
            if(callbacks == null){
                return;
            }
        }
        callbacks.notifyCallbacks(this,0,null);
    }
    public void notifyPropertyChanged(int field){
        synchronized (this){
            if(callbacks == null) {
                return;
            }
        }
        callbacks.notifyCallbacks(this,field,null);
    }

}
