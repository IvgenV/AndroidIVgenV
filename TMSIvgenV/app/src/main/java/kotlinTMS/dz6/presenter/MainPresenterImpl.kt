package kotlinTMS.dz6.presenter

import android.widget.Toast
import kotlinTMS.dz6.model.DatabaseManager
import kotlinTMS.dz6.view.Dz6MainView

class MainPresenterImpl(private val manager:DatabaseManager,private val view:Dz6MainView):MainPresenter {

    override fun requestAge() {
        view.setAge(manager.getage())
    }

    override fun changeAge() {
        if(view.changeAge()==-1){

        }else manager.changeAge(view.changeAge())
    }

    override fun requestUrl() {
        view.setAvatar(manager.getUrl())
    }

    override fun changeUrl() {
        if(view.changeUrl() == "Error 404!"){

        }else manager.changeUrl(view.changeUrl())
    }
}