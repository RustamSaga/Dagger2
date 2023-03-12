package com.rustamsaga.dagger2

import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface APpComponent {
    val computer: Computer

    fun injectMainActivity(mainActivity: MainActivity)
}


@Module
object AppModule {

    @Provides
    fun provideProcessor(): Processor = Processor()

    @Provides
    fun provideMotherboard(): Motherboard = Motherboard()

    @Provides
    fun provideRAM(): RAM = RAM()

    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer = Computer(processor, motherboard, ram)
}