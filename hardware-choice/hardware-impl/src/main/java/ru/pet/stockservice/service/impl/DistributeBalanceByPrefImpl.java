package ru.pet.stockservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.pet.stockservice.dto.UserPreferenceDto;
import ru.pet.stockservice.dto.UserProfileDto;
import ru.pet.stockservice.service.DistributeBalanceByPref;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistributeBalanceByPrefImpl implements DistributeBalanceByPref {
    @Value("${app.balance.high-priority-multiplier.gpu}")
    private Double highGpuMultiply;
    @Value("${app.balance.high-priority-multiplier.cpu}")
    private Double highCpuMultiply;
    @Value("${app.balance.default-multiplier.gpu}")
    private Double defaultCpuMultiPly;
    @Value("${app.balance.default-multiplier.gpu}")
    private Double defaultGpuMultiply;
    @Value("${app.balance.default-multiplier.ram}")
    private Double defaultRamMultiply;

    @Override
    public Map<String, Double> distribute(UserProfileDto userProfileDto) {
        Double balance = userProfileDto.getPurchaseBudget();
        Map<String, Double> distributedBalance = new HashMap<>();
        for (UserPreferenceDto currentPreference : userProfileDto.getUserPreferences()) {
            if (currentPreference.getName().equals("games") && currentPreference.getPriority().getPriority().equals("high")) {
                double gpuPrice = balance * highGpuMultiply;
                distributedBalance.put("gpu", gpuPrice);
                balance -= gpuPrice;
            }
            if (currentPreference.getName().equals("office") && currentPreference.getPriority().getPriority().equals("high")) {
                double processorPrice = balance * highCpuMultiply;
                distributedBalance.put("cpu", processorPrice);
                balance -= processorPrice;
            }

        }
        distributedBalance.putIfAbsent("cpu", balance * defaultCpuMultiPly);
        distributedBalance.putIfAbsent("gpu", balance * defaultGpuMultiply);
        distributedBalance.putIfAbsent("ram", balance * defaultRamMultiply);

        return distributedBalance;
    }
}
