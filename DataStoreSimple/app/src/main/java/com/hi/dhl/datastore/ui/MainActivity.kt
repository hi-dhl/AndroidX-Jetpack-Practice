package com.hi.dhl.datastore.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.hi.dhl.datastore.R
import com.hi.dhl.datastore.protobuf.PersonProtos
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sp.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        with(switchAccount) {
            isChecked = mainViewModel.getData(PreferencesKeys.KEY_ACCOUNT)
            setOnClickListener(this@MainActivity)
        }

        switchWeiBo.setOnClickListener(this)
        switchGitHub.setOnClickListener(this)
        btnMrge.setOnClickListener(this)
        btnSaveProtoData.setOnClickListener(this)
        btnMrgeProto.setOnClickListener(this)

        initObserve()
    }

    private fun initObserve() {
        /**
         * KEY_WEI_BO 或者 KEY_GITHUB 只要其中一个变化了，都会收到通知
         */
        mainViewModel.getDataStore(PreferencesKeys.KEY_WEI_BO)
            .observe(this@MainActivity) {
                switchWeiBo.isChecked = it
            }

        mainViewModel.getDataStore(PreferencesKeys.KEY_GITHUB)
            .observe(this@MainActivity) {
                switchGitHub.isChecked = it
            }

        mainViewModel.getProtoDataStoreForPerson().observe(this@MainActivity) {
            fillData(it)
        }
    }

    override fun onClick(v: View) {
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
            btnSaveProtoData -> mainViewModel.saveProtoDataStoreForPerson(
                PersonModel(
                    age = etPersonAge.text.toString().toIntOrNull() ?: 0,
                    name = etPersonName.text.toString()
                )
            )
            btnMrgeProto -> {
                mainViewModel.migrationSP2ProtoDataStore()
                // 这里是为了测试迁移是否成功，必须执行一次读取或者写入
                mainViewModel.getProtoDataStoreForPerson().observe(this@MainActivity) {
                    fillData(it)
                }
                Toast.makeText(this@MainActivity, "迁移成功", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun fillData(person: PersonProtos.Person) {
        etPersonAge.setText(person.age.toString())
        etPersonName.setText(person.name.ifEmpty { "hi-dhl.com" })
        follow.isChecked = person.followAccount
        tvListener.setText("测试监听保存和迁移结果 \n:  ${person}")
    }

    companion object {
        private val TAG: String = "MainActivity"
    }

}