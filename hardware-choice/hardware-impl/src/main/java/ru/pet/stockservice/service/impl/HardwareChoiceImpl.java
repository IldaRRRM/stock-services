package ru.pet.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.dto.CpuDto;
import ru.pet.stockservice.dto.GpuDto;
import ru.pet.stockservice.dto.RamDto;
import ru.pet.stockservice.dto.UserOrderDto;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.model.Cpu;
import ru.pet.stockservice.model.Gpu;
import ru.pet.stockservice.model.Ram;
import ru.pet.stockservice.model.UserOrder;
import ru.pet.stockservice.repository.UserOrderRepository;
import ru.pet.stockservice.service.CpuService;
import ru.pet.stockservice.service.DistributeBalanceByPref;
import ru.pet.stockservice.service.GpuService;
import ru.pet.stockservice.service.HardwareChoice;
import ru.pet.stockservice.service.RamService;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class HardwareChoiceImpl implements HardwareChoice {

    private final CpuService cpuService;
    private final GpuService videoAdapterService;
    private final DistributeBalanceByPref distributeBalanceByPref;
    private final RamService ramService;
    private final ModelMapper mapper;
    private final UserOrderRepository orderRepository;

    @Override
    public UserOrderDto pickHardware(UserProfileDto userProfileDto) {
        Map<String, Double> priceMap = distributeBalanceByPref.distribute(userProfileDto);
        Cpu cpu = cpuService.pickCpuByPreference(priceMap.get("cpu"));
        Gpu gpu = videoAdapterService.pickGpu(priceMap.get("gpu"));
        Ram ram = ramService.pickRam(priceMap.get("ram"));

        UserOrderDto userOrderDto = new UserOrderDto();
        userOrderDto.setGpu(mapper.map(gpu, GpuDto.class));
        userOrderDto.setCpu(mapper.map(cpu, CpuDto.class));
        userOrderDto.setRam(mapper.map(ram, RamDto.class));
        userOrderDto.setUsername(userProfileDto.getUsername());

        UserOrder userOrder = mapper.map(userOrderDto, UserOrder.class);
        orderRepository.save(userOrder);
        return userOrderDto;
    }
}
