package kotlinTMS.dz8.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinTMS.dz8.model.Constants

class DataViewModel : ViewModel() {

    companion object {
        const val TAG = Constants.TAG + " DataViewModel"
    }

    var text1:MutableLiveData<String> = MutableLiveData()
    var text2:MutableLiveData<String> = MutableLiveData()

    fun getText1():LiveData<String>{
        Log.d(TAG, "getText $this")
        return text1
    }

    fun setText1(str:String){
        Log.d(TAG, "setText $text1 ($this)")
        text1.value = str
    }
    fun getText2():LiveData<String>{
        Log.d(TAG, "getText $this")
        return text2
    }

    fun setText2(str:String){
        Log.d(TAG, "setText $text1 ($this)")
        text2.value = str
    }

}