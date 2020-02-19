package iot.empiaurhouse.mvvm.viewmodel;

import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import iot.empiaurhouse.mvvm.model.Element;
import iot.empiaurhouse.mvvm.repositories.ChemicalRepository;

public class PeriodicTableViewModel extends ViewModel {

    private MutableLiveData<List<Element>> elements;
    private ChemicalRepository chemicalRepository;
    private MutableLiveData<Boolean> updateStatus = new MutableLiveData<>();

    public void init(){
        if(elements != null){
            return;
        }
        chemicalRepository = ChemicalRepository.getInstance();
        elements = chemicalRepository.getElementsData();
    }

    //Webservice Fetch Simulation
    public void addLiveData(final Element element){
        updateStatus.setValue(true);

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                List<Element> stagedElementList = elements.getValue();
                stagedElementList.add(element);
                elements.postValue(stagedElementList);
                updateStatus.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(3333);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();

    }

    public LiveData<List<Element>> getElementsLiveData(){
        return elements;
    }

    public LiveData<Boolean> getUpdateStatus(){
        return updateStatus;
    }

}
