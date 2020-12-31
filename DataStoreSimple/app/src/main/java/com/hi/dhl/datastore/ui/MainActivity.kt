package com.hi.dhl.datastore.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.hi.dhl.binding.viewbind
import com.hi.dhl.datastore.R
import com.hi.dhl.datastore.databinding.ActivitySpBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/1
 *     desc  : hi-dhl 的公众号：ByteCode
 * </pre>
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mainViewModel: MainViewModel by viewModels()
    private val binding: ActivitySpBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViews().forEach {
            it.setOnClickListener(this@MainActivity)
        }

        binding.switchAccount.isChecked = mainViewModel.getData(PreferencesKeys.KEY_ACCOUNT)
        initObserve()
    }

    private fun getViews() = binding.run {
        arrayListOf(switchAccount, switchWeiBo, switchGitHub, btnMrge)
    }

    private fun initObserve() {
        /**
         * KEY_WEI_BO 或者 KEY_GITHUB 只要其中一个变化了，都会收到通知
         */
        mainViewModel.getDataStore(PreferencesKeys.KEY_WEI_BO)
            .observe(this@MainActivity) {
                binding.switchWeiBo.isChecked = it
            }

        mainViewModel.getDataStore(PreferencesKeys.KEY_GITHUB)
            .observe(this@MainActivity) {
                binding.switchGitHub.isChecked = it
            }
    }

    override fun onClick(v: View) {
        with(binding) {
            when (v) {
                switchAccount -> mainViewModel.saveData(PreferencesKeys.KEY_ACCOUNT)
                switchWeiBo -> mainViewModel.saveDataByDataStore(PreferencesKeys.KEY_WEI_BO)
                switchGitHub -> mainViewModel.saveDataByDataStore(PreferencesKeys.KEY_GITHUB)
                btnMrge -> {
                    /**
                     *  传入 migrations 参数，构建一个 DataStore 之后，
                     *  需要执行 一次读取 或者 写入，DataStore 才会自动合并 SharedPreference 文件内容
                     */
                    mainViewModel.migrationSP2DataStore()
                    lifecycleScope.launch {
                        mainViewModel.testMigration(PreferencesKeys.KEY_BYTE_CODE).collect()
                    }
                    Toast.makeText(this@MainActivity, "迁移成功", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        private val TAG: String = "MainActivity"
    }

}