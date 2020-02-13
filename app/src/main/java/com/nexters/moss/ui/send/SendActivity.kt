package com.nexters.moss.ui.send

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nexters.moss.R
import com.nexters.moss._base.BaseActivity
import com.nexters.moss.databinding.ActivitySendBinding
import com.nexters.moss.model.CakeModel
import com.nexters.moss.ui.send.adapter.SendAdapter
import com.nexters.moss.ui.send.adapter.SendListDecoration
import kotlinx.android.synthetic.main.activity_send.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SendActivity : BaseActivity<ActivitySendBinding>() {
    override val vm: SendViewModel by viewModel()
    override fun getLayoutRes() = R.layout.activity_send
    override fun setupBinding() {
        binding.vm = vm
    }

    private var cakeList = arrayListOf<CakeModel>(
        CakeModel("물마시기", R.drawable.send_select_watermelon),
        CakeModel("스트레칭", R.drawable.send_select_cheese),
        CakeModel("명상", R.drawable.send_select_cream),
        CakeModel("산책", R.drawable.send_select_green_tea),
        CakeModel("뉴스보기", R.drawable.send_select_coffee),
        CakeModel("아침먹기", R.drawable.send_select_apple),
        CakeModel("일기쓰기", R.drawable.send_select_chestnut),
        CakeModel("책읽기", R.drawable.send_select_almond)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupCakeRecyclerView()

        vm.setCakeList(cakeList)
        textChangeListener()

        btn_send_cake_send.setOnClickListener {
            toast("click")
        }
    }

    private fun setupCakeRecyclerView() {

        layout_send_cake_recycler.apply {
            adapter = SendAdapter()

            layoutManager = LinearLayoutManager(
                this@SendActivity, RecyclerView.HORIZONTAL, false
            )

            addItemDecoration(SendListDecoration())
        }
    }

    private fun textChangeListener() {
        edit_txt_send_cake_message.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.length > 2) {
                    vm.isTextLengthEnough(true)
                } else {
                    vm.isTextLengthEnough(false)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

}
