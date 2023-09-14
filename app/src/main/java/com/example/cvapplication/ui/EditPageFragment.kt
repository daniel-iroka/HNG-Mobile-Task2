package com.example.cvapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cvapplication.R
import com.example.cvapplication.databinding.FragmentEditPageBinding
import com.example.cvapplication.viewmodel.PersonalInformationSharedViewModel

class EditPageFragment : Fragment() {
    private var _binding : FragmentEditPageBinding? = null
    private val binding get() = _binding !!
    private val args by navArgs<EditPageFragmentArgs>()
    private val viewModel : PersonalInformationSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditPageBinding.inflate(layoutInflater, container, false)

        binding.fullNameEdt.apply {
            addTextChangedListener(viewModel.fullNameTextChangedListener)
            setText(args.personalInfoArgs.fullName)
        }
        binding.slackUserNameEdt.apply {
            addTextChangedListener(viewModel.slackUserNameTextChangedListener)
            setText(args.personalInfoArgs.slackUsername)
        }
        binding.githubHandleEdt.apply {
            addTextChangedListener(viewModel.githubHandleTextChangedListener)
            setText(args.personalInfoArgs.githubHandle)
        }
        binding.bioMtl.apply {
            addTextChangedListener(viewModel.bioTextChangedListener)
            setText(args.personalInfoArgs.personalBio)
        }
        binding.saveDetailsBtn.setOnClickListener {
            if (viewModel.detailsCheck()) {
                viewModel.savePersonalDetails()
                findNavController().navigate(R.id.action_editPageFragment_to_homePageFragment)
                Toast.makeText(context, R.string.successful_toast_message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, R.string.error_text_message, Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}