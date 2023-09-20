package com.example.promobank.data.datasource.fake

import com.example.promobank.model.Formats
import com.example.promobank.model.Img
import com.example.promobank.model.PromosResponseItem
import com.example.promobank.model.Small

private val smallMock = Small(
    ext = ".jpg",
    url = "https://strapi-jkt-digi46.s3.ap-southeast-3.amazonaws.com/small_bni_credit_card_banner_fitur_mbanking_small_b8d822ed1c.jpg",
    hash = "small_bni_credit_card_banner_fitur_mbanking_small_b8d822ed1c",
    mime = "image/jpeg",
    name = "small_bni-credit-card-banner-fitur-mbanking-small.jpg",
    size = 18.45,
    width = 500,
    height = 219
)

private val smallMock1 = Small(
    ext = ".jpg",
    url = "https://strapi-jkt-digi46.s3.ap-southeast-3.amazonaws.com/small_bni_banner_qris_mudah_2020_small_8f0e73341a.jpg",
    hash = "small_bni_banner_qris_mudah_2020_small_8f0e73341a",
    mime = "image/jpeg",
    name = "small_bni-banner-qris-mudah-2020-small.jpg",
    size = 21.83,
    width = 500,
    height = 181
)

private val formatMock = Formats(
    small = smallMock
)

private val formatMock1 = Formats(
    small = smallMock1
)

private val imgMock1 = Img(
    id = 3,
    name = "bni-credit-card-banner-fitur-mbanking-small.jpg",
    alternativeText = "",
    width = 825,
    height = 361,
    url = "https://strapi-jkt-digi46.s3.ap-southeast-3.amazonaws.com/bni_banner_qris_mudah_2020_small_8f0e73341a.jpg",
    formats = formatMock
)

private val imgMock2 = Img(
    id = 4,
    name = "bni-banner-qris-mudah-2020-small.jpg",
    alternativeText = "",
    width = 825,
    height = 298,
    url = "https://strapi-jkt-digi46.s3.ap-southeast-3.amazonaws.com/small_bni_banner_qris_mudah_2020_small_8f0e73341a.jpg",
    formats = formatMock1
)

val promoItemMockList = listOf(
    PromosResponseItem(
        id = 1,
        latitude = "-6.203606",
        publishedAt = "2021-04-14T03:35:09.233Z",
        createdAt = "2021-04-13",
        updatedAt = "2021-07-31T14:48:46.361Z",
        nama = "BNI Credit Card",
        desc = "Potongan langsung (diskon) Rp 150.000,- untuk minimal transaksi Rp 1.000.000, kuota 15 transaksi pertama per hari.\\n- Berlaku tiap Kamis dan Jumat.\\n- Berlaku untuk pembelian Tiket Sriwijaya Air dan NAM Air di Website dan Mobile Apps Sriwijaya Air\\n- Potongan harga langsung diperoleh ketika nomor Kartu BNI dimasukkan (tanpa kode promo)\\n- Syarat dan ketentuan berlaku\\nInfo lebih lanjut hubungi BNI Call 1500046",
        longitude = "106.803022",
        alt = "17",
        createdAtFormatted = "2021-04-13",
        lokasi = "Pejompongan",
        count = 14,
        img = imgMock1
    ),
    PromosResponseItem(
        id = 2,
        latitude = "-6.3468207686453",
        publishedAt = "2021-04-15T05:52:34.665Z",
        createdAt = "2021-04-14",
        updatedAt = "2021-07-31T14:49:08.295Z",
        nama = "BNI QRIS",
        desc = "Nikmati bayar tunai tanpa kartu di bni mobile banking, anda bisa scan qris pada semua merchant yang ada di merchant yang berpartisipasi pada MCC Groceries, Pharmacies, dan Minimarket. Info lebih lanjut hubungi BNI Call 1500046",
        longitude = "106.56324387883",
        alt = "17",
        createdAtFormatted = "2021-04-13",
        lokasi = "Parung Panjang",
        count = 15,
        img = imgMock2
    )
)