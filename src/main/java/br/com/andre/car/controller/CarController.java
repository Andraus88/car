package br.com.andre.car.controller;

import br.com.andre.car.dto.CarDtoRequest;
import br.com.andre.car.dto.CarDtoResponse;
import br.com.andre.car.exception.CarBrandNotAllowedException;
import br.com.andre.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")

public class CarController {

    @Autowired
    CarService carService;

    // Para salvar no banco de dados:
    @PostMapping("/post")
    public String post(@RequestBody CarDtoRequest carDtoRequest) throws CarBrandNotAllowedException {
        carService.save(carDtoRequest);
        return "Successful post!";
    }

    @GetMapping("/get/{idChassi}")
    public CarDtoResponse get(@PathVariable Long idChassi) {
        return carService.getByID(idChassi);
    }
}
