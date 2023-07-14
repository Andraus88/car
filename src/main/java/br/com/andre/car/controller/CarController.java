package br.com.andre.car.controller;

import br.com.andre.car.entity.Car;
import br.com.andre.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")

public class CarController {

    @Autowired
    CarService carService;
    @GetMapping("/get")
    public String get(){
        return carService.getString();
    }

    // Para salvar no banco de dados:
    @PostMapping("/post")
    public Car post(@RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping("/get/{idChassi}")
    public Car post (@PathVariable Long idChassi) {
        return carService.getByID(idChassi);
    }
}
