package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.model.Cpu;
import ru.pet.stockservice.repository.CpuRepository;
import ru.pet.stockservice.service.CpuService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CpuServiceImpl implements CpuService {

    private final CpuRepository cpuRepository;

    @Override
    public Cpu pickCpuByPreference(Double price) {
        List<Cpu> byPriceLessThanEqualOrderByPrice = cpuRepository.findAllByPriceIsLessThanEqualOrderByPrice(price);
        return byPriceLessThanEqualOrderByPrice.get(byPriceLessThanEqualOrderByPrice.size() - 1);
    }
}
