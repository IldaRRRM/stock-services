package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.model.Gpu;
import ru.pet.stockservice.repository.GpuRepository;
import ru.pet.stockservice.service.GpuService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GpuServiceImpl implements GpuService {

    private final GpuRepository gpuRepository;

    @Override
    public Gpu pickGpu(Double sum) {
        List<Gpu> allByPriceIsLessThanEqualOrderByPrice = gpuRepository.findAllByPriceIsLessThanEqualOrderByPrice(sum);
        return allByPriceIsLessThanEqualOrderByPrice.get(allByPriceIsLessThanEqualOrderByPrice.size() - 1);
    }
}
