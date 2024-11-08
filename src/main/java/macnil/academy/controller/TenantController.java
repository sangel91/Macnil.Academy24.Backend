package macnil.academy.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import macnil.academy.model.Tenant;
import macnil.academy.repository.TenantRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/tenant")
public class TenantController {
    

    @Autowired
    TenantRepository tenantRepository;


     @GetMapping
    public @ResponseBody List<Tenant> getAllPost() {

        return tenantRepository.findAll();

    }


}
