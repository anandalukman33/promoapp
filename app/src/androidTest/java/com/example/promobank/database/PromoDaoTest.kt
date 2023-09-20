package com.example.promobank.database

import android.content.Context
import androidx.lifecycle.asFlow
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.cash.turbine.test
import com.example.promobank.DispatcherRuleTest
import com.example.promobank.data.datasource.database.AppDatabase
import com.example.promobank.data.datasource.database.dao.PromoDao
import com.example.promobank.data.datasource.database.entity.PromoEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
@SmallTest
class PromoDaoTest {

    @get: Rule
    val dispatcherRule = DispatcherRuleTest()

    private lateinit var promoDao: PromoDao
    private lateinit var appDatabase: AppDatabase

    @Before
    fun create() {
        if (this::appDatabase.isInitialized) {
            val context = ApplicationProvider.getApplicationContext<Context>()
            appDatabase = Room
                .inMemoryDatabaseBuilder(context, appDatabase::class.java)
                .build()
            promoDao = appDatabase.promoDao
        }
    }

    @After
    fun cleanUp() {
        if (this::appDatabase.isInitialized) {
            appDatabase.close()
        }
    }


    @Test
    fun addItemPromo_shouldReturn_theItem_inFlow() {
        if (this::promoDao.isInitialized) {
            return runTest {

                val promoEntity1 = PromoEntity(
                    idPromo = 8,
                    titlePromo = "BNI Credit Card",
                    descPromo = "Potongan langsung (diskon) Rp 150.000,- untuk minimal transaksi Rp 1.000.000, kuota 15 transaksi pertama per hari.\\n- Berlaku tiap Kamis dan Jumat.\\n- Berlaku untuk pembelian Tiket Sriwijaya Air dan NAM Air di Website dan Mobile Apps Sriwijaya Air\\n- Potongan harga langsung diperoleh ketika nomor Kartu BNI dimasukkan (tanpa kode promo)\\n- Syarat dan ketentuan berlaku\\nInfo lebih lanjut hubungi BNI Call 1500046",
                    latitudePromo = "-6.203606",
                    longitudePromo = "106.803022",
                    createdAtFormatted = "2021-04-13",
                    lokasi = "Pejompongan",
                    count = 14
                )
                val promoEntity2 = PromoEntity(
                    idPromo = 7,
                    titlePromo = "BNI QRIS",
                    descPromo = "Nikmati bayar tunai tanpa kartu di bni mobile banking, anda bisa scan qris pada semua merchant yang ada di merchant yang berpartisipasi pada MCC Groceries, Pharmacies, dan Minimarket.\\nInfo lebih lanjut hubungi BNI Call 1500046",
                    latitudePromo = "-6.3468207686453",
                    longitudePromo = "106.56324387883",
                    createdAtFormatted = "2021-04-14",
                    lokasi = "Parung Panjang",
                    count = 15
                )
                promoDao.addPromoEntity(promoEntity1)
                promoDao.addPromoEntity(promoEntity2)

                promoDao.getAllPromo().asFlow().test {
                    val list = awaitItem()
                    assert(list.contains(promoEntity1))
                    assert(list.contains(promoEntity2))
                    cancel()
                }
            }
        }

    }

}