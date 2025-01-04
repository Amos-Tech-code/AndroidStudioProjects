package com.example.retrofittestapp.data

import com.example.retrofittestapp.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductsRepositoryImpl(
    private val api: Api
): ProductsRepository {
    override suspend fun getProductList(): Flow<Result<List<Product>>> {
        return flow {
            val productsFromApi = try {

                api.getProductList()

            } catch (e: IOException) {
                emit(Result.Error(e.message ?: "Error loading products"))
                return@flow
            } catch (e: HttpException) {
                emit(Result.Error(e.message ?: "Error loading products"))
                return@flow
            }
            catch (e: Exception) {
                emit(Result.Error(e.message ?: "Unknown error"))
                return@flow
            }

            emit(Result.Success(productsFromApi.products))

        }
    }
}