package com.hi.dhl.datastore.data

import android.content.Context
import androidx.datastore.CorruptionException
import androidx.datastore.DataStore
import androidx.datastore.Serializer
import androidx.datastore.createDataStore
import com.hi.dhl.datastore.protobuf.PersonProtos
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
        androidx.datastore.migrations.SharedPreferencesMigration<PersonProtos.Person>(
            context,
            SharedPreferencesRepository.PREFERENCE_NAME
        ) { sharedPreferencesView, person ->
            person
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

    suspend fun saveData(age: Int) {
        protoDataStore.updateData { person ->
            person.toBuilder().setAge(age).build()
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
            return PersonProtos.Person.parseFrom(input)
        } catch (exception: Exception) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: PersonProtos.Person, output: OutputStream) = t.writeTo(output)
}
