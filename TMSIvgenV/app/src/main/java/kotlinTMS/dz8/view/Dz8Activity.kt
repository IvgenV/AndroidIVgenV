package kotlinTMS.dz8.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tmsivgenv.R
import kotlinTMS.dz8.model.Constants

class Dz8Activity : AppCompatActivity(),DataListener,ChangeFragment {

    companion object{
        const val TAG = Constants.TAG + " MainActivity"
    }

    lateinit var secondFragment: SecondFragment
    lateinit var firstFragment: FirstFragment
    lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz8)
        val savedFirstFragment = supportFragmentManager.findFragmentByTag(FirstFragment.TAG)
        firstFragment = (savedFirstFragment ?: FirstFragment.newInstance()) as FirstFragment
        val savedSecondFragment = supportFragmentManager.findFragmentByTag(SecondFragment.TAG)
        secondFragment = (savedSecondFragment ?: SecondFragment.newInstance()) as SecondFragment
        val savedThirdFragment = supportFragmentManager.findFragmentByTag(ThirdFragment.TAG)
        thirdFragment = (savedThirdFragment ?: ThirdFragment.newInstance()) as ThirdFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame1, firstFragment,FirstFragment.TAG).replace(R.id.frame2,secondFragment,SecondFragment.TAG)
                .commitNow()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onTextChangedTV1(str: String) {
        Log.d(TAG, "onTextChanged")
        if(secondFragment.isResumed){
            secondFragment.setMessage(str)
        }else{
            Log.d(TAG, "not resumed")
        }
    }

    override fun changeFragment() {
        if(secondFragment.isResumed){
            supportFragmentManager.beginTransaction().replace(R.id.frame2,thirdFragment,ThirdFragment.TAG).commit()
        }else if(thirdFragment.isResumed){
            supportFragmentManager.beginTransaction().replace(R.id.frame2,secondFragment,SecondFragment.TAG).commit()
        }
    }

}