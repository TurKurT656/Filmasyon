package com.turkurt656.data.remote.exception

import java.io.IOException

data class ApiResponseException(override val message: String, val code: Int): IOException()