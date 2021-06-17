package com.systems.unittesting.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.systems.unittesting.entity.UserEntity
import com.systems.unittesting.getOrAwaitValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest // Remove AndroidJunitRunner and Use HiltAndroidTest
@ExperimentalCoroutinesApi
@SmallTest
class UserTestDao {

    // A JUnit Test Rule that swaps the background executor
    // used by the Architecture Components with a different one which executes each task synchronously
    @get:Rule(order = 0)
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    // Define HiltRule
    @get:Rule(order = 1) // define order
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test-db")
    lateinit var userDatabase: UserDatabase
    private lateinit var userDao: UserDao

    // execute before every test case
    @Before
    fun setup() {
        hiltRule.inject()
        userDao = userDatabase.userDao()
    }

    // execute after every test case
    @After
    fun teardown() {
        userDatabase.close()
    }

    /*
    test case to insert user in room database
    */
    @Test
    fun insertUser() = runBlockingTest {
        val userEntity = UserEntity("Arsalan Khan", 26, "Some Random Email", 1)
        userDao.insert(userEntity)
        val users = userDao.getUsersList().getOrAwaitValue()
        assertThat(users).contains(userEntity)
    }

    /*
    test case to delete user in room database
    */
    @Test
    fun deleteUser() = runBlockingTest {
        val userEntity = UserEntity("Arsalan Khan", 26, "Some Random Email", 1)
        userDao.insert(userEntity)
        userDao.delete(userEntity)
        val users = userDao.getUsersList().getOrAwaitValue()
        assertThat(users).doesNotContain(userEntity)
    }

    /*
    test case to insert and update user in room database
    */
    @Test
    fun updateUser() = runBlockingTest {
        val userEntity = UserEntity("Arsalan Khan", 26, "Some Random Email", 1)
        userDao.insert(userEntity)
        val newUser = userEntity.copy(name = "Munir Ahmad")
        userDao.update(newUser)
        val users = userDao.getUsersList().getOrAwaitValue()
        assertThat(users).contains(newUser)
    }
}