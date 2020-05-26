package ru.pet.stockservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.pet.stockservices.controller.UserAdminController;

@FeignClient(name = "user-admin-users", url = "${USER_PROFILE_AUTH:http://localhost:9191/auth/admin")
public interface UserAdminControllerFeign extends UserAdminController {
}
