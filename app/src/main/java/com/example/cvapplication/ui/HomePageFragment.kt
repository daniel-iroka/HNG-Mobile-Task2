package com.example.cvapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.cvapplication.databinding.FragmentHomePageBinding
import com.example.cvapplication.model.PersonalInformation
import com.example.cvapplication.viewmodel.PersonalInformationSharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageFragment : Fragment() {

    private var _binding : FragmentHomePageBinding? = null
    private val binding get() = _binding !!
    private val viewModel : PersonalInformationSharedViewModel by activityViewModels()
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(layoutInflater, container, false)

        setupObserver()
        return binding.root
    }

    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.personalInformation.flowWithLifecycle(lifecycle).collect { personalInformation ->
                setupViews(personalInformation)
            }
        }
    }

    private fun setupViews(personalInfo : PersonalInformation) {
        // binding our views in the UI/Main thread enables for smooth updating of the Ui and smooth-
        // responsiveness
        uiScope.launch {
            binding.apply {
                fullNameTv.text = personalInfo.fullName
                slackUserNameTv.text = personalInfo.slackUsername
                githubHandleTv.text = personalInfo.githubHandle
                bioTv.text = personalInfo.personalBio
                editDetailsBtn.setOnClickListener {
                    val action = HomePageFragmentDirections.actionHomePageFragmentToEditPageFragment(personalInfo)
                    findNavController().navigate(action)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}