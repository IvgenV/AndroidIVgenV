package kotlinTMS.dz8.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tmsivgenv.R
import kotlinTMS.dz8.model.Constants
import kotlinTMS.dz8.viewModel.DataViewModel

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
        const val TAG = Constants.TAG + " ThirdFragment"
    }

    private lateinit var viewModel: DataViewModel
    lateinit var tvText1:TextView
    lateinit var tvText2:TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        Log.d(SecondFragment.TAG,"onCreateView")
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvText1 = view.findViewById(R.id.TvText1Fragment3)
        tvText2 = view.findViewById(R.id.TvText2Fragment3)
        viewModel = ViewModelProvider(requireActivity()).get("viewModel", DataViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getText1().observe(requireActivity(),{
            tvText1.text = it
        })
        viewModel.getText2().observe(requireActivity(),{
            tvText2.text = it
        })
    }
}