package ru.pet.stockservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.pet.stockservice.controller.UserProfileController;

@FeignClient(name = "user-profile-users", url = "${USER_PROFILE_URL:http://localhost:9193}")
public interface UserProfileControllerFeign extends UserProfileController {

}
