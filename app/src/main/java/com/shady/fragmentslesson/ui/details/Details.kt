package com.shady.fragmentslesson.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shady.fragmentslesson.R
import com.shady.fragmentslesson.data.model.User

class Details : Fragment() {

    companion object {
        fun newInstance() = Details()
    }

    private lateinit var viewModel: DetailsViewModel
    private lateinit var idTextView: TextView
    private lateinit var fNameTextView: TextView
    private lateinit var lNameTextView: TextView
    private lateinit var scoreTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
       if (arguments != null){
           requireArguments().getParcelable<User>("userKey").let{
               idTextView = view.findViewById(R.id.tvIdDetails)
               fNameTextView = view.findViewById(R.id.tvfName)
               lNameTextView = view.findViewById(R.id.tvlName)
               scoreTextView = view.findViewById(R.id.tvScore)

               idTextView.text = "User ID: ${it?.id}"
               fNameTextView.text = "First Name: ${it?.fName}"
               lNameTextView.text = "Last Name: ${it?.lName}"
               scoreTextView.text = "User Score: ${it?.score}"
           }




       }

    }

}