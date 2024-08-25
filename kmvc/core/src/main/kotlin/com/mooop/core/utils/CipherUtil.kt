package com.mooop.core.utils

import javax.crypto.Cipher
import javax.crypto.SecretKey

/**
 * Project : kmvc
 * Package :com.mooop.core.utils
 * Author :  zinnaworks
 * Date : 27/04/2022
 * Desc :
 */
object CipherUtil {
    const val GENERATE_STRING = "1234567890abcdefghizklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    var cipher:Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
}