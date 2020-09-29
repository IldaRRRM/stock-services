package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.model.Ram;
import ru.pet.stockservice.repository.RamRepository;
import ru.pet.stockservice.service.RamService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;

    @Override
    public Ram pickRam(Double price) {
        List<Ram> allByPriceLessThanEqualOrderByPrice = ramRepository.findAllByPriceLessThanEqualOrderByPrice(price);
        return allByPriceLessThanEqualOrderByPrice.get(allByPriceLessThanEqualOrderByPrice.size() - 1);
    }
}
