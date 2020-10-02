package com.hi.dhl.datastore.ui

import android.os.Bundle
import android.widget.CompoundButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.datastore.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sp.*

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/1
 *     desc  : hi-dhl 的公众号：ByteCode
 * </pre>
 */

@AndroidEntryPoint
class DataStoreActivity : AppCompatActivity(),
    CompoundButton.OnCheckedChangeListener {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        with(switchAccount) {
            isChecked = mainViewModel.getData(KEY_ACCOUNT)
            setOnCheckedChangeListener(this@DataStoreActivity)
        }

        with(switchWeiBo) {
            isChecked = mainViewModel.getData(KEY_WEI_BO)
            setOnCheckedChangeListener(this@DataStoreActivity)
        }

        with(switchGitHub) {
            isChecked = mainViewModel.getData(key_GITHUB)
            setOnCheckedChangeListener(this@DataStoreActivity)
        }

        switchStore.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView) {
            switchAccount -> mainViewModel.saveData(
                KEY_ACCOUNT,
                !mainViewModel.getData(KEY_ACCOUNT)
            )
            switchWeiBo -> mainViewModel.saveData(KEY_WEI_BO, !mainViewModel.getData(KEY_WEI_BO))
            switchGitHub -> mainViewModel.saveData(key_GITHUB, !mainViewModel.getData(key_GITHUB))
        }
    }

    companion object {
        private val KEY_ACCOUNT = "ByteCode"
        private val KEY_WEI_BO = "weibo"
        private val key_GITHUB = "GitHub"
    }
}