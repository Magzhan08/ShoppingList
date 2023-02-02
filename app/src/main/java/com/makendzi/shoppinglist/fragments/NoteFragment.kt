package com.makendzi.shoppinglist.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.makendzi.shoppinglist.R
import com.makendzi.shoppinglist.activities.MainApp
import com.makendzi.shoppinglist.activities.NewNoteActivity
import com.makendzi.shoppinglist.databinding.FragmentNoteBinding
import com.makendzi.shoppinglist.db.MainViewModel


class NoteFragment : BaseFragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var editLauncher: ActivityResultLauncher<Intent>

    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).dataBase)
    }
    override fun onClickNew() {
        editLauncher.launch(Intent(activity,NewNoteActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEditResult()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun onEditResult(){
        editLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                if (it.resultCode == Activity.RESULT_OK){
                    Log.d("MyLog", "title: ${it.data?.getStringExtra(TITLE_KEY)}")
                    Log.d("MyLog", "description: ${it.data?.getStringExtra(DESCRIPTION_KEY)}")
                }
        }
    }

    companion object {
        const val TITLE_KEY = "title_key"
        const val DESCRIPTION_KEY = "description_key"
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}