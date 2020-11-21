package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.di

import android.content.Context
import androidx.room.Room
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.CyclingDatabase
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.UserDatabase
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.WeightDatabase
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.other.Constants.CYCLING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCyclingDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        CyclingDatabase::class.java,
        CYCLING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        CYCLING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideWeightDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        WeightDatabase::class.java,
        CYCLING_DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun providesCycleDao(db: CyclingDatabase) = db.getCycleDao()

    @Singleton
    @Provides
    fun providesUserDao(db: UserDatabase) = db.getUserDao()

    @Singleton
    @Provides
    fun providesWeightDao(db: WeightDatabase) = db.getWeightDao()
}