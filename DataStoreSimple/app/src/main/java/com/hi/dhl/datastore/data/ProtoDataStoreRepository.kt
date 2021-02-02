package com.hi.dhl.datastore.data

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.createDataStore
import androidx.datastore.migrations.SharedPreferencesMigration
import com.hi.dhl.datastore.protobuf.PersonProtos
import com.hi.dhl.datastore.ui.PersonModel
import com.hi.dhl.datastore.ui.PreferencesKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 *
 *     DataStore 文件存放目录: /data/data/<包名>/files/datastore
 *     hi-dhl 的公众号：ByteCode
 *
 * </pre>
 */


class ProtoDataStoreRepository(val context: Context) {

    private val FILE_NAME = "ProtoDataStore.pb"

    private val shardPrefsMigration =
            SharedPreferencesMigration<PersonProtos.Person>(
                    context,
                    SharedPreferencesRepository.PREFERENCE_NAME
            ) { sharedPreferencesView, person ->

                // 获取 SharedPreferences 的数据
                val follow = sharedPreferencesView.getBoolean(
                        PreferencesKeys.KEY_ACCOUNT,
                        false
                )

                // 将 SharedPreferences 每一对 key-value 数据映射到 Proto DataStore 中
                // 将 SP 文件中  ByteCode : true 数据迁移到 Person 的成员变量 followAccount 中
                person.toBuilder()
                        .setFollowAccount(follow)
                        .build()
            }

    var protoDataStore: DataStore<PersonProtos.Person> =
            context.createDataStore(fileName = FILE_NAME, serializer = PersonSerializer)


    fun migrationSP2DataStore() {
        protoDataStore = context.createDataStore(
                fileName = FILE_NAME,
                serializer = PersonSerializer,
                migrations = listOf(shardPrefsMigration)
        )
    }

    suspend fun saveData(personModel: PersonModel) {
        protoDataStore.updateData { person ->
            person.toBuilder().setAge(personModel.age).setName(personModel.name).build()
        }
    }

    fun readData(): Flow<PersonProtos.Person> {
        return protoDataStore.data
                .catch {
                    if (it is IOException) {
                        it.printStackTrace()
                        emit(PersonProtos.Person.getDefaultInstance())
                    } else {
                        throw it
                    }
                }
    }

}

object PersonSerializer : Serializer<PersonProtos.Person> {
    override fun readFrom(input: InputStream): PersonProtos.Person {
        try {
            return PersonProtos.Person.parseFrom(input) // 是编译器自动生成的，用于读取并解析 input 的消息
        } catch (exception: Exception) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: PersonProtos.Person, output: OutputStream) = t.writeTo(output) // t.writeTo(output) 是编译器自动生成的，用于写入序列化消息

    override val defaultValue: PersonProtos.Person
        get() = PersonProtos.Person.getDefaultInstance()
}
