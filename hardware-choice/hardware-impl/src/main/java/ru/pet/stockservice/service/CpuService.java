package ru.pet.stockservice.service;

import ru.pet.stockservice.model.Cpu;

public interface CpuService {

    Cpu pickCpuByPreference(Double price);

}
