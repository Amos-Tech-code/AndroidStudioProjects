package com.example.retrofittestapp.data

import com.example.retrofittestapp.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getProductList(): Flow<Result<List<Product>>>
}