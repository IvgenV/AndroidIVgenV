package kotlinTMS.dz8.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import com.example.tmsivgenv.R
import com.google.android.material.textfield.TextInputEditText
import kotlinTMS.dz8.model.Constants
import kotlinTMS.dz8.viewModel.DataViewModel

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
        const val TAG = Constants.TAG + " FirstFragment"
    }

    private lateinit var viewModel: DataViewModel
    private var listener: DataListener? = null
    private var change: ChangeFragment?=null
    private lateinit var edit1:TextInputEditText
    private lateinit var edit2:TextInputEditText
    private lateinit var button:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.d(TAG,"onCreateView")
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get("viewModel", DataViewModel::class.java)
        Log.d(TAG,"onActivityCreated")

        edit1.doOnTextChanged{text, start, before, count ->
            viewModel.setText1(text.toString())
        }
        edit2.doOnTextChanged { text, _, _, _ ->
            viewModel.setText2(text.toString())
        }
        button.setOnClickListener {
            change?.changeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edit1 = view.findViewById(R.id.edit1)
        edit2 = view.findViewById(R.id.edit2)
        button = view.findViewById(R.id.changeFragmentButton)
        Log.d(TAG,"onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG,"onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"onAttach")
        if(context is DataListener){
            listener = context
        }
        if(context is ChangeFragment){
            change = context
        }
    }

    /*override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        Log.d(TAG,"onAttachFragment")
    }*/
}