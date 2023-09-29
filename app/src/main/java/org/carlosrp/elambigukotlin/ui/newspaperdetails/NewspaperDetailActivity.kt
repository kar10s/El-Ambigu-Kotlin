package org.carlosrp.elambigukotlin.ui.newspaperdetails

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.carlosrp.elambigukotlin.databinding.ActivityNewspaperDetailBinding
import org.carlosrp.elambigukotlin.ui.newspaper.NewspaperViewModel

@AndroidEntryPoint
class NewspaperDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNewspaperDetailBinding
    private val newspaperViewModel:NewspaperViewModel by viewModels()
    private val args: NewspaperDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewspaperDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTitle.text=args.type.name
       // binding.ivDetail.setImageResource(args.type.name)

    }


}